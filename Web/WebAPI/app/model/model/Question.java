package model.model;

import java.util.List;

import model.model.TrivialQuestion.Categories;

public interface Question {
	
	public String getQuestion();
	public List<String> getAnswers();
	public int getPositionTrue();
	public Categories getCategory();
}
