package logic;

import java.util.ArrayList;
import java.util.List;

import logic.DB.MongoQuestionManager;
import logic.DB.MongoUserManager;
import logic.board.Board;
import logic.model.Die;
import logic.model.Player;
import logic.model.Statistics;
import logic.model.User;
import Model.Question;

public class Game {

	private Board board;
	private List<Player> players;
	private Player activePlayer;

	public Game() {
		List<Question> questions = new MongoQuestionManager().getQuestions();
		board = new Board(new QuestionSelector(questions));
		players = new ArrayList<Player>();
	}

	public Board getBoard() {
		return board;
	}

	public void addPlayer(Player player) {
		if (players.isEmpty()) {
			activePlayer = player;
		}
		players.add(player);
	}

	public Player nextPlayer() {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).equals(activePlayer)) {
				if (i + 1 < players.size()) {
					activePlayer = players.get(i + 1);
					break;
				} else {
					activePlayer = players.get(0);
					break;
				}
			}
		}
		return activePlayer;
	}

	public boolean trueAnswer(Question question, int answer) {
		return question.getPositionTrue() == answer;
	}

	public User login(String username, String password) {
		User user = new MongoUserManager().getUser(username);
		if (user != null && user.getPassword().equals(password))
			return user;
		return null;
	}

	public User register(String username, String email, String password) {
		User user = new User(username, password, email, new Statistics(0, 0, 0));
		if (new MongoUserManager().saveUser(user))
			return user;
		return null;

	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void changePositionPlayer(Player player, String string) {
		String[] position = string.split("_");
		player.getPosition().setWalk(Integer.valueOf(position[0]));
		player.getPosition().setIndex(Integer.valueOf(position[1]));
		for (Player p : players) {
			if (player.getUsername().equals(p.getUsername()))
				p.setPosition(player.getPosition());
		}

	}

	public void closeDatabase() {

	}

	public int throwDie() {
		return Die.drop();
	}
}
