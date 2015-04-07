package Model;

import java.util.List;

import Model.TrivialQuestion.Categories;

public interface Question {
	
	public String getQuestion();
	public List<String> getAnswers();
	public int getPositionTrue();
	public Categories getCategory();
}
