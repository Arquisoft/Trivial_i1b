package controllers;

import java.util.ArrayList;
import java.util.List;

import model.model.Question;
import model.Game;
import model.board.square.Square;
import model.model.Player;
import model.model.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.initial;
import views.html.login;
import views.html.newUser;
import views.html.statistics;
import views.html.*;

public class Application extends Controller {

	private static Game game = new Game();
	private static List<String> squares = new ArrayList<String>();

	public static Result initial() {
		return ok(initial.render());
	}

	public static Result register(String url) {
		String[] urlArray = url.split("&");
		String username = urlArray[0];
		String password = urlArray[1];
		String email = urlArray[2];
		User user = game.register(username, email, password);
		if (user != null) {
			if (user.getUsername().equals("admin"))
				return ok(statistics.render());
			else
				return ok(initial.render());
		} else {
			return gotoNewUser();
		}
	}

	public static Result gotoLogin() {
		return ok(login.render());
	}

	public static Result gotoNewUser() {
		return ok(newUser.render());
	}

	public static Result login(String url) {
		String[] urlArray = url.split("&");
		String username = urlArray[0];
		String password = urlArray[1];
		User user = game.login(username, password);
		if (user != null) {
			if (user.getUsername().equals("admin"))
				return ok(statistics.render());
			else
				return initializeBoard(user);
		} else {
			return gotoLogin();
		}
	}

	public static Result gotoStatistics() {
		return ok(statistics.render());
	}

	public static Result initializeBoard(User user) {
		game.addPlayer(new Player(user, 6));
		return ok(board.render(0, user.getUsername(), squares, game
				.getActivePlayer().getPosition().toString()));
	}

	public static Result board() {
		return ok(board.render(0, game.getActivePlayer().getUsername(),
				squares, game.getActivePlayer().getPosition().toString()));
	}

	public static Result move(String id) {
		game.changePositionPlayer(game.getActivePlayer(),
				id.substring(0, id.length()));
		return board();
	}

	public static Result throwDie() {
		int dieNumber = game.throwDie();
		squares = getPosition(game.getBoard().move(game.getActivePlayer(),
				dieNumber));
		return ok(board.render(dieNumber, game.getActivePlayer()
				.getUsername(), squares, game.getActivePlayer().getPosition()
				.toString()));
	}

	private static List<String> getPosition(Square[] square) {
		List<String> list = new ArrayList<String>();
		for (Square squ : square) {
			list.add(squ.getPosition().toString());
		}
		return list;
	}

	public static Result showQuestion(String id) {
		Question question=game.getBoard().getQuestions().getQuestion(
								game.getBoard().getSquare(
												game.getActivePlayer().getPosition()).getCategories());
		return ok(questions.render(
			question.getQuestion(), question.getAnswers()));
	}

	// public boolean isActive(String id) {
	// for (Square s : squares) {
	// if (s.toString().equals(id))
	// return true;
	// }
	// return false;
	// }
}
