package es.uniovi.seti.Model;

import java.util.List;

public class TrivialQuestion implements Question {

	private String question;

	private List<String> answers;

	private int positionTrue;

	public TrivialQuestion(String question, List<String> answers,
			int positionTrue) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(question + "\n");
		for (String answer : answers)
			builder.append("\t" + answer.toString() + "\n");
		builder.append(positionTrue + "\n");
		
		return builder.toString();
	}

}
