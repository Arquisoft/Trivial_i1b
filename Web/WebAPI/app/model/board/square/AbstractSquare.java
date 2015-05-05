package model.board.square;

import model.board.square.Square;
import model.model.Position;
import model.model.TrivialQuestion.Categories;

public class AbstractSquare implements Square{
	
	Categories category;
	
	Position position;
	
	public Position getPosition() {
		return position;
	}


	public AbstractSquare(Categories category,Position position){
		this.position = position;
		this.category=category;
	}


	@Override
	public Categories getCategories() {
		return category;
	}

}
