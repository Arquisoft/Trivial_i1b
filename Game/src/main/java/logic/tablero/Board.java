package logic.tablero;

import logic.QuestionSelector;
import logic.model.Player;
import logic.model.Position;
import logic.tablero.square.CompositeSquare;
import logic.tablero.square.SimpleSquare;
import logic.tablero.square.Square;
import Model.TrivialQuestion.Categories;

public class Board {
	
	public static final int DEFAULT_SIZE = 42;
	
	private QuestionSelector questions; 
	private int size; 
	
	private Square[] board;
	
	public Board(QuestionSelector questions){
		this.size = DEFAULT_SIZE;
		this.questions = questions; 
		initializeBoard();
	}

	  
	public Board(int size, QuestionSelector questions){
		this.size = size;
		this.questions = questions;
		initializeBoard();
	}
	
	
	public void initializeBoard(){
		board = new Square[size];
		//The square in the position 0,0 is the Central Square. 
		board[0] = new SimpleSquare(Categories.values()[(int) (Math.random() * Categories.values().length)], new Position(0,0));
		for(int i=1;i< size+1; i+=Categories.values().length){
			int j=i;
			for (Categories c : Categories.values()){
				board[j] = new SimpleSquare(c,new Position(0,j));
				j++;
			}
			if(j % Categories.values().length == 0)
			board[j] = new CompositeSquare(Categories.values()[j/Categories.values().length],new Position(0,j),Categories.values().length-1);
		}
	}
	
		
	private Square getSquare(Position position){
		if(position.getWalk() == 0)
			return board[position.getIndex()];
		return ((CompositeSquare)board[position.getIndex()%Categories.values().length]).getWalk()[position.getIndex()];
	}
	

//	public void mover(Position position, int movements){
//		for(int i =0 ; i < movements;i++){
//			if()
//		}
//	}

	
	public int getSize() {
		return size;
	}
	
	public QuestionSelector getQuestions() {
		return questions;
	}

	
	
	
}