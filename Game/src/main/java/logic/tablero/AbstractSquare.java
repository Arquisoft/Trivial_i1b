package logic.tablero;

import logic.tablero.square.Square;
import Model.TrivialQuestion.Categories;

public class AbstractSquare implements Square{
	
	Categories category;
	
	public AbstractSquare(Categories category){
		this.category=category;
	}


	@Override
	public Categories getCategories() {
		return category;
	}

}
