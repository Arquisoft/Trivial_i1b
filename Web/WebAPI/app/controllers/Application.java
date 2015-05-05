package controllers;

import model.Game;
import model.board.square.Square;
import model.model.Player;
import model.model.Position;
import model.model.Statistics;
import model.model.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	private static Game game = new Game();
	private static Square[] squares;
	private static Player player;
	
    public static Result initial() {
        return ok(initial.render());
    }
    
    public static Result initializeBoard(){
    	player = new Player(new User("user", "passwd", "user@email.es", new Statistics(1, 90000, 90000)), 6);
    	return ok(board.render());
    }
    
    public static Result board(){
    	return ok(board.render());
    }
    
    public static Result move(String id){
//    	game.addPlayer(new Player(new User("user", "passwd", "user@email.es", new Statistics(1, 90000, 90000)), 6));
    	player = new Player(new User("user", "passwd", "user@email.es", new Statistics(1, 90000, 90000)), 6);
    	new Game().changePositionPlayer(player, "2_5");
    	return ok(board.render());
    }
    
    public static Result throwDie(){
    	squares = game.getBoard().move(player, game.throwDie());
    	return ok(board.render());
    }
}
