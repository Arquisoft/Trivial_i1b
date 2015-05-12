package controllers;

import java.util.ArrayList;
import java.util.List;

import model.model.Question;
import model.Game;
import model.board.square.Square;
import model.model.Player;
import model.model.User;
import model.DB.MongoStatisticsManager;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.initial;
import views.html.login;
import views.html.newUser;
import views.html.statistics;
import views.html.*;

public class Application extends Controller {

	private static MongoStatisticsManager mongo= new MongoStatisticsManager();
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
				return ok(statistics.render(game.getUsers()));
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
				return ok(statistics.render(game.getUsers()));
			else
				return initializeBoard(user);
		} else {
			return gotoLogin();
		}
	}

	public static Result gotoStatistics() {
		return ok(statistics.render(game.getUsers()));
	}

	public static Result initializeBoard(User user) {
		game.addPlayer(new Player(user, 6));
		return ok(board.render(0, game.getActivePlayer(), squares, ""));
	}

	public static Result board(String message) {
		return ok(board.render(0, game.getActivePlayer(), squares, message));
	}

	public static Result throwDie() {
		int dieNumber = game.throwDie();
		squares = getPosition(game.getBoard().move(game.getActivePlayer(),
				dieNumber));
		return ok(board.render(dieNumber, game.getActivePlayer(), squares, ""));
	}

	private static List<String> getPosition(Square[] square) {
		List<String> list = new ArrayList<String>();
		for (Square squ : square) {
			list.add(squ.getPosition().toString());
		}
		return list;
	}

	public static Result showQuestion(String id) {
		game.changePositionPlayer(game.getActivePlayer(),
				id.substring(0, id.length()));
		squares = new ArrayList<String>();
		return ok(questions
				.render(game
						.getBoard()
						.getQuestions()
						.getQuestion(
								game.getBoard()
										.getSquare(
												game.getActivePlayer()
														.getPosition())
										.getCategories())));
	}

	public static Result checkAnswer(int answer) {
		Question question = game.getBoard()
				.getQuestions()
				.getQuestion(
						game.getBoard()
								.getSquare(game.getActivePlayer().getPosition())
								.getCategories());

		if (game.trueAnswer(question, answer)) {
			game.getActivePlayer().getWedges()[question.getCategory().getValue()] = true;
			if (game.getActivePlayer().allQuestionsMatched())
				return ok(win.render());
			}
			endGame(game.getActivePlayer());
			return board("Your answer was right");
		} else
			game.getActivePlayer().getUser().getStatistics().
				setQuestionsAnswered(
					game.getActivePlayer().getUser().
						getStatistics().getQuestionsAnswered()+1);
			return board("Your answer was wrong. Try again.");
	}
	
	private static void updateData(Player player){
		User user=player.getUser();
		user.getStatistics().setQuestionsMatched(
				user.getStatistics().getQuestionsMatched()+1);
		user.getStatistics().setQuestionsAnswered(
				user.getStatistics().getQuestionsAnswered()+1);
		mongo.updateStatistics(user);
	}
	private static void endGame(Player player){
		updateData(player);
		User user=player.getUser();
		user.getStatistics().setTimesPlayed(
				user.getStatistics().getTimesPlayed()+1);
		mongo.updateStatistics(user);
	}
}
