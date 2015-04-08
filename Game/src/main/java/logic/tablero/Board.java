package logic.tablero;

import Model.TrivialQuestion.Categories;
import logic.QuestionSelector;
import logic.tablero.square.SimpleSquare;
import logic.tablero.square.Square;

public class Board {

	
	public static int DEFAULT_SIZE = 46;
	
	private QuestionSelector questions; 
	private int size; 
	
	private Square[] board;
	
	public Board(QuestionSelector questions){
		this.size = DEFAULT_SIZE;
		this.setQuestions(questions); 
	}

	  
//	public Board(int size, QuestionSelector questions){
//		this.size = size;
//		this.setQuestions(questions); 
//	}
	
	
	public void initializeBoard(){
		board = new Square[46];
		for(int i=0;i< size; i+=7){
			int j=i;
			board[j] = new SimpleSquare(Categories.ART);
			board[j+1] = new SimpleSquare(Categories.ENTERTAINMENT);
			board[j+2] = new SimpleSquare(Categories.GEOGRAPHY);
			
		}
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @return the questions
	 */
	public QuestionSelector getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(QuestionSelector questions) {
		this.questions = questions;
	}
	
	
	
}