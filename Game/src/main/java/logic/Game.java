package logic;


import java.util.List;

import logic.DB.MongoQuestionManager;
import logic.DB.MongoUserManager;
import logic.board.Board;
import logic.model.Player;
import logic.model.User;
import Model.Question;

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
	
	public boolean login(String username, String password) {
		User user = new MongoUserManager().getUser(username);
		if(user != null && user.getPassword().equals(password))
			return true;
		return false;
	}
}
