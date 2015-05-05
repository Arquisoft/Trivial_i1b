package controllers;

import model.Game;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	private Game game; 

	public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    

    public static Result initial() {
        return ok(initial.render());
    }
    
    public static Result initialize(){
    	//game = new Game();
    	return ok(board.render());
    }
    
    public static Result board(){
    	return ok(board.render());
    }
    
    public static Result move(String id){
    	return ok(board.render());
    }
}
