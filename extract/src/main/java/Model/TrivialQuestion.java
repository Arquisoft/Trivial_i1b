package Model;

import java.util.List;

public class TrivialQuestion implements Question {
	
	public enum Categories {
		GEOGRAPHY(0), ENTERTAINMENT(1), HISTORY(2), ART(3), SCIENCE(4), SPORT(5);
		private int value;

		public int getValue() {
			return value;
		}

		private Categories(int value) {
			this.value = value;
		}
		
	};

	private String question;

	private List<String> answers;

	private int positionTrue;
	
	private Categories category;

	public TrivialQuestion(Categories category, String question, List<String> answers,
			int positionTrue) {
		this.category = category;
		this.question = question;
		this.answers = answers;
		this.positionTrue = positionTrue;
	}

	public String getQuestion() {
		return this.question;
	}

	public List<String> getAnswers() {
		return this.answers;
	}

	public int getPositionTrue() {
		return this.positionTrue;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getCategory().toString() + "\n");
		builder.append(question + "\n");
		for (String answer : answers)
			builder.append("\t" + answer.toString() + "\n");
		builder.append(positionTrue + "\n");
		
		return builder.toString();
	}

}
