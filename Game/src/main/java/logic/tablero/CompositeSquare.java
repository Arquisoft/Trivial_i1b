package logic.tablero;

import Model.TrivialQuestion.Categories;


public class CompositeSquare extends AbstractSquare{

	private Square[] walk;
	
	public CompositeSquare(Categories category, int size) {
		super(category);
		this.walk = new Square[size];
	}

	/**
	 * @return the walk
	 */
	public Square[] getWalk() {
		return walk;
	}

	/**
	 * @param walk the walk to set
	 */
	public void setWalk(Square[] walk) {
		this.walk = walk;
	}

	
	
}
