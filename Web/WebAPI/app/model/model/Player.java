package model.model;

import java.util.Random;

import model.model.Position;
import model.model.User;

public class Player {

	private User user;

	/*
	 * From 0 to n wedges assigned to each player at the start of the game true
	 * if the player has match the question, false otherwise, all players start
	 * with all the wedges with false value.
	 */
	private boolean[] wedges;
	
	private Position position;

	public Player(User user, int numberOfWedges) {
		this.user = user;
		this.position = new Position(0,9);//new Random().nextInt(42)+1);
		this.wedges = new boolean[numberOfWedges];
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean[] getWedges() {
		return wedges;
	}

	public boolean allQuestionsMatched() {
		for (boolean bool : wedges)
			if (!bool)
				return false;
		return true;
	}
	
	public User getUser() {
		return user;
	}
}
