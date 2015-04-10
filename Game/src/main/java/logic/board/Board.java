package logic.board;

import java.util.ArrayList;
import java.util.List;

import logic.QuestionSelector;
import logic.board.square.CompositeSquare;
import logic.board.square.SimpleSquare;
import logic.board.square.Square;
import logic.model.Player;
import logic.model.Position;
import Model.TrivialQuestion.Categories;

public class Board {

	public static final int DEFAULT_SIZE = 42;

	private QuestionSelector questions;
	private int size;

	private Square[] board;
	
	private Categories[] special = new Categories[]{Categories.GEOGRAPHY,Categories.SPORT,Categories.HISTORY,Categories.ENTERTAINMENT,Categories.SCIENCE,Categories.ART};
		
	public Board(QuestionSelector questions) {
		this.size = DEFAULT_SIZE;
		this.questions = questions;

		initializeBoard();
	}

	public Board(int size, QuestionSelector questions) {
		this.size = size;
		this.questions = questions;
		initializeBoard();
	}

	public void initializeBoard() {
		board = new Square[size + 1];
		// The square in the position 0,0 is the Central Square.
		board[0] = new SimpleSquare(
				Categories.values()[(int) (Math.random() * Categories.values().length)],
				new Position(0, 0));
		for (int i = 1; i < size; i += (Categories.values().length+1)) {
			int j = i;
			for (Categories c : Categories.values()) {
				board[j] = new SimpleSquare(c, new Position(0, j));
				j++;
			}
			if (j % (Categories.values().length+1) == 0){
				Categories c = special[(j / (Categories.values().length+1))-1];
				Position p = new Position(0,j);
				int s =  Categories.values().length ; 
				board[j] = new CompositeSquare(c,p,s);
			}
		}
	}

	public Square[] getBoardA() {
		return board;
		}
	
	//Revisar su uso para borrar.
	public Square getSquare(Position position) {
		if (position.getWalk() == 0)
			return board[position.getIndex()];
		return ((CompositeSquare) board[position.getWalk()
				* Categories.values().length]).getArrayWalk()[position
				.getIndex()];
	}

	public Square[] mover(Player player, int movements) {
		List<Square> posibleMovements = new ArrayList<Square>();
		if (player.getPosition().getWalk() == 0) {
			for (int i = 0; i < movements; i++) {
				if (board[player.getPosition().getIndex() + i] instanceof CompositeSquare
						&& player.allQuestionsMatched()) {
					posibleMovements
							.add(((CompositeSquare) board[player.getPosition()
									.getIndex() + i]).getArrayWalk()[movements
									- i]);
				}
			}
			posibleMovements.add(board[newExternalPosition(player.getPosition() ,movements)]);
			posibleMovements.add(board[newExternalPosition(player.getPosition(), -movements)]);
		} else {
			if (player.getPosition().getIndex() + movements < Categories
					.values().length) {
				posibleMovements.add(board[player.getPosition().getIndex()
						+ movements]);
			}
		}

		return (Square[]) posibleMovements.toArray();

	}

	public int getSize() {
		return size;
	}

	public QuestionSelector getQuestions() {
		return questions;
	}

	//Revisar para borrar.
	public boolean validPosition(Position position) {
		if (position.getWalk() == 0) {
			if (position.getIndex() <= DEFAULT_SIZE && position.getIndex() >= 0)
				return true;
		} else {
			if (position.getIndex() >= 0
					&& position.getIndex() < Categories.values().length)
				return true;
		}
		return false;
	}

	private int newExternalPosition(Position position, int movement) {
		int newPosition = position.getIndex();
		if ((position.getIndex() + movement) > DEFAULT_SIZE)
			newPosition = DEFAULT_SIZE - (position.getIndex() + movement);
		return newPosition;
	}

}