package logic;


import java.util.List;

import logic.DB.MongoQuestionManager;
import logic.tablero.Board;
import Model.Question;

public class Game {
	
	private Board board;
	
	public Game(){
		
		List<Question> questions = MongoQuestionManager.getQuestions();
		board = new Board(new QuestionSelector(questions));
	}
	
	public Board getBoard() {
		return board;
	}

	

}
