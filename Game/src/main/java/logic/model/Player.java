package logic.model;

public class Player {

	private String username;
	/*
	 * From 0 to n wedges assigned to each player at the start of the game true
	 * if the player has match the question, false otherwise, all players start
	 * with all the wedges with false value.
	 */
	private boolean[] wedges;
	
	private Position position;

	public Player(String username, int numberOfWedges) {
		this.position = new Position(0,1);
		this.username = username;
		this.wedges = new boolean[numberOfWedges];
	}

	public Position getPosition() {
		return position;
	}

	protected void setPosition(Position position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public boolean[] getWedges() {
		return wedges;
	}

	public boolean allQuestionsMatched() {
		for (int i = 0; i < wedges.length; i++)
			if (!wedges[i])
				return false;
		return true;
	}
}
