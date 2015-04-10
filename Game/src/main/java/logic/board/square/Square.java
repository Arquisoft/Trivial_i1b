package logic.board.square;

import logic.model.Position;
import Model.TrivialQuestion.Categories;

public interface Square {
	
	public Categories getCategories();
	public Position getPosition();
}
