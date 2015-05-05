package model.board.square;

import model.model.Position;
import model.model.TrivialQuestion.Categories;

public interface Square {
	
	public Categories getCategories();
	public Position getPosition();
}
