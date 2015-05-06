package controllers;

import model.Game;
import model.board.square.Square;
import model.model.Player;
import model.model.Position;
import model.model.Statistics;
import model.model.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.board;
import views.html.initial;

public class Application extends Controller {

	private static Game game = new Game();
	private static Square[] squares;
	private static Player player = new Player(new User("user", "passwd", "user@email.es", new Statistics(1, 90000, 90000)), 6);
	
    public static Result initial() {
        return ok(initial.render());
    }
    
    public static Result register() {
    	return ok(board.render(0));
    }
    
    public static Result initializeBoard(){
    	return ok(board.render(0));
    }
    
    public static Result board(){
    	return ok(board.render(0));
    }
    
    public static Result move(String id){
    	game.changePositionPlayer(player, "2_5");
    	return ok(board.render(0));
    }
    
    public static Result throwDie(){
    	int dieNumber = game.throwDie();
    	squares = game.getBoard().move(player, dieNumber);
    	return ok(board.render(dieNumber));
    }
}
