package logic.model;

public class Statistics {
	private int timesPlayed;
	private int questionsAnswered;
	private int questionsMatched;

	public Statistics(int timesPlayed, int questionsAnswered, int questionsRight) {
		this.timesPlayed = timesPlayed;
		this.questionsAnswered = questionsAnswered;
		this.questionsMatched = questionsRight;
	}

	public int getTimesPlayed() {
		return timesPlayed;
	}

	public void setTimesPlayed(int timesPlayed) {
		this.timesPlayed = timesPlayed;
	}

	public int getQuestionsAnswered() {
		return questionsAnswered;
	}

	public void setQuestionsAnswered(int questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}

	public int getQuestionsMatched() {
		return questionsMatched;
	}

	public void setQuestionsMatched(int questionsMatched) {
		this.questionsMatched = questionsMatched;
	}
}
