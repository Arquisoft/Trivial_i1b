package controllers;

import model.Game;
import model.board.square.SimpleSquare;
import model.board.square.Square;
import model.model.Player;
import model.model.Position;
import model.model.Statistics;
import model.model.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.board;
import views.html.initial;
import views.html.login;
import views.html.newUser;
import views.html.statistics;

public class Application extends Controller {

	private static Game game = new Game();
	private static Square[] squares = {new SimpleSquare(null,new Position(1,3)),new SimpleSquare(null,new Position(1,1)) };
	
    public static Result initial() {
        return ok(initial.render());
    }
    
    public static Result register(String username, String email, String password) {
    	if (!(username.isEmpty() && email.isEmpty() && password.isEmpty())) {
    		game.register(username, email, password);
    	
    	}
    	return ok(newUser.render(username, email, password));
    	
    	//return ok(error.render("Error"));
    }
    
    public static Result gotoLogin() {
		return ok(login.render(null, null, null));
	}
    
    public static Result gotoNewUser() {
		return ok(newUser.render(null, null, null));
	}
    
    public static Result gotoStatistics() {
		return ok(statistics.render());
	}
    
    public static Result login(String username, String password){
    	if (!(username.isEmpty() && password.isEmpty())) {
    		game.login("usernameLogin", "passwordLogin");
    	}
    	return ok(board.render(0));
    }
    
    public static Result initializeBoard(){
    	game.addPlayer(new Player(new User("user", "passwd", "user@email.es", new Statistics(1, 90000, 90000)), 6));
    	return ok(board.render(0));
    }
    
    public static Result board(){
    	return ok(board.render(0));
    }
    
    public static Result move(String id){
    	game.changePositionPlayer(game.getActivePlayer(), id.substring(0, id.length()));
    	return board();
    }
    
    public static Result throwDie(){
    	int dieNumber = game.throwDie();
    	squares = game.getBoard().move(game.getActivePlayer(), dieNumber);
    	return ok(board.render(dieNumber));
    }
    
    public boolean isActive(String id){
    	for(Square s: squares){
    		if(s.toString().equals(id))
    			return true;
    	}
		return false;	
    }
}
