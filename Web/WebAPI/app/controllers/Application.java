package controllers;

import model.Game;
import model.board.square.SimpleSquare;
import model.board.square.Square;
import model.model.Player;
import model.model.Position;
import model.model.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.board;
import views.html.initial;
import views.html.login;
import views.html.newUser;
import views.html.statistics;
import views.html.boardImage;

public class Application extends Controller {

	private static Game game = new Game();
	private static Square[] squares = {
			new SimpleSquare(null, new Position(1, 3)),
			new SimpleSquare(null, new Position(1, 1)) };

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
				return initializeBoard(user);
		} else {
			return gotoNewUser();
		}
	}

	public static Result gotoLogin() {
		return ok(login.render(null, null));// No information have to be already
											// written
	}

	public static Result gotoNewUser() {
		return ok(newUser.render(null, null, null));
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
		return ok(boardImage.render(0,user.getUsername()));
	}

	public static Result board(String username) {
		return ok(boardImage.render(0, username));
	}

	public static Result move(String id) {
		game.changePositionPlayer(game.getActivePlayer(),
				id.substring(0, id.length()));
		return board(game.getActivePlayer().getUsername());
	}

	public static Result throwDie(String username) {
		int dieNumber = game.throwDie();
		squares = game.getBoard().move(game.getActivePlayer(), dieNumber);
		return ok(boardImage.render(dieNumber,username));
	}

	public boolean isActive(String id) {
		for (Square s : squares) {
			if (s.toString().equals(id))
				return true;
		}
		return false;
	}
}
