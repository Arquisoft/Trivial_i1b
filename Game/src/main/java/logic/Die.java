package logic;

public class Die {
	
	public static final int MAXLIMIT = 6;
	private static Die instance = null;
	
	private Die(){
	}
	
	public static Die getInstance() {
		if(instance == null)
			instance = new Die();
		return instance;
	}

	public static int drop(){
		int number = (int) (Math.random() * MAXLIMIT) + 1;
		return number;
	}
}
