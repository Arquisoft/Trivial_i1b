package logic.model;

public class User {
	
	private String username;
	private String password;
	private String email;
	private Statistics statistics;


	public User(String username, String password, String email, Statistics statistics) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.statistics = statistics;
	}
	
	public Statistics getStatistics() {
		return statistics;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
