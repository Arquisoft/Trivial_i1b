package model.model;

public class Die {
	
	public static final int MAXLIMIT = 6;


	public static int drop(){
		int number = (int) (Math.random() * MAXLIMIT) + 1;
		return number;
	}
}
