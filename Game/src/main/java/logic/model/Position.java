package logic.model;

import Model.TrivialQuestion.Categories;
import logic.tablero.Board;

public class Position {

	/**
	 * This class is used to record the position of the players on the board. 
	 * At first is recorded the walk. If its cero it means that it's on the external circle,
	 * the array that it's record on the Board. If it's diferent to cero it means that it's on
	 *  one of the six different squares that contains the board that goes to the Special Square. 
	 *  The index is the position of the array on the Principal circles or in the internal walks. 
	 */
	
	private int walk;
	private int index;


	public Position(int walk, int index) {
		this.walk = walk; 
		this.index = index;
	}

	public int getWalk() {
		return walk;
	}

	public int getIndex() {
		return index;
	}

	public boolean validPosition() {
		if (this.walk == 0){
			if(this.index < Board.DEFAULT_SIZE)
				return true;
		}
		else{ 
			if(this.index < Categories.values().length)
				return true; 
		}
		return false; 
	}

}
