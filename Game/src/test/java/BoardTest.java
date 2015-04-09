import logic.QuestionSelector;
import logic.DB.MongoQuestionManager;
import logic.board.Board;
import logic.board.square.CompositeSquare;
import logic.board.square.SimpleSquare;
import logic.board.square.Square;

import org.junit.Test;



public class BoardTest {

	
	@Test
	public void test() {
		Board board = new Board(new QuestionSelector(new MongoQuestionManager().getQuestions()));
		
		for(Square square: board.getBoardA()){
			if(square instanceof CompositeSquare){
				System.out.print("Composite Square -WALK: " + square.getCategories());
				System.out.println();
				for(Square sq : ((CompositeSquare) square).getArrayWalk()){
					System.out.println( "	CAMINO " +sq.getCategories());
				}
			}
			else{
				if(square instanceof SimpleSquare)
					System.out.println("Simple Square -" + square.getCategories());
				
			}
		}
	}

}
