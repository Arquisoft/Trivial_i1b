package es.uniovi.seti.Model;

import java.util.List;

public interface Question {
	
	public String getQuestion();
	public List<String> getAnswers();
	public int getPositionTrue();
}
