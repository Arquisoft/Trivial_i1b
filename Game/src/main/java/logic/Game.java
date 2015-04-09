package logic;


import java.util.ArrayList;
import java.util.List;

import logic.DB.MongoQuestionManager;
import logic.DB.MongoUserManager;
import logic.board.Board;
import logic.model.Player;
import logic.model.User;

import Model.Question;

public class Game {
	
	private Board board;
	
	private List<Player> players;

	private Player activePlayer;
	
	public Game(){
		
		List<Question> questions = new MongoQuestionManager().getQuestions();
		board = new Board(new QuestionSelector(questions));
		players = new ArrayList<Player>();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void addPlayer(Player player){
		if(players.isEmpty()){
			activePlayer = player;
		}
		players.add(player);
	}

	public Player nextPlayer() {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).equals(activePlayer)) {
				if (i + 1 < players.size())
					activePlayer = players.get(i + 1);
				else
					activePlayer = players.get(0);
			}
		}
		return activePlayer;
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

	public List<Player> getPlayers() {
		return players;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}
}
