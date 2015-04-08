package logic.tablero;

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
