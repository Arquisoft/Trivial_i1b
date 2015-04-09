package logic.board.square;

import logic.model.Position;
import Model.TrivialQuestion.Categories;

public class CompositeSquare extends AbstractSquare {

	private Square[] arrayWalk;

	public CompositeSquare(Categories category,Position position, int size) {
		super(category, position);
		int walkNum= position.getIndex()%Categories.values().length;
		arrayWalk[0] = new SimpleSquare(category,new Position(walkNum,0));
		this.arrayWalk = new Square[size];
		int i = 1;
		for (Categories c : Categories.values()) {
			if (!c.equals(category)) {
				arrayWalk[i] = new SimpleSquare(c,new Position(walkNum,i));
			}
			i++;
		}
	}

	
	public Square[] getArrayWalk() {
		return arrayWalk;
	}

	public void setArrayWalk(Square[] arrayWalk) {
		this.arrayWalk = arrayWalk;
	}

}
