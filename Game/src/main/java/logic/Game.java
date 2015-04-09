package logic;


import java.util.List;

import Model.Question;
import logic.DB.MongoQuestionManager;
import logic.board.Board;
import logic.model.Player;

public class Game {
	
	private Board board;
	
	private Player[] players;

	private Player activePlayer;
	
	public Game(int numPlayers){
		
		List<Question> questions = new MongoQuestionManager().getQuestions();
		board = new Board(new QuestionSelector(questions));
		players = new Player[numPlayers];
		activePlayer = players[0];
	}
	
	public Board getBoard() {
		return board;
	}

	public void nextPlayer() {
		for (int i = 0; i < players.length; i++) {
			if (players[i].equals(activePlayer)) {
				if (i + 1 < players.length)
					activePlayer = players[i + 1];
				else
					activePlayer = players[0];
			}
		}
	}
	
	public boolean trueAnswer(Question question,int answer){
		return question.getPositionTrue() == answer; 
	}
}
