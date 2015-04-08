package logic.tablero.square;

import logic.model.Position;
import Model.TrivialQuestion.Categories;

public class CompositeSquare extends AbstractSquare {

	private Square[] walk;

	public CompositeSquare(Categories category,Position position, int size) {
		super(category, position);
		int walkNum= position.getIndex()%Categories.values().length;
		walk[0] = new SimpleSquare(category,new Position(walkNum,0));
		this.walk = new Square[size];
		int i = 1;
		for (Categories c : Categories.values()) {
			if (!c.equals(category)) {
				walk[i] = new SimpleSquare(c,new Position(walkNum,i));
			}
			i++;
		}
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
