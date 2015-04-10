package logic.board.square;

import logic.model.Position;
import Model.TrivialQuestion.Categories;

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
