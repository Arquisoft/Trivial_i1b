package logic.model;

public class Dice {
	
	public static final int MAXLIMIT = 6;
	private static Dice instance = null;

	public static int drop(){
		int number = (int) (Math.random() * MAXLIMIT) + 1;
		return number;
	}
}
