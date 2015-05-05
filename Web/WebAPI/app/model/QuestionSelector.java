package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.model.Question;
import model.model.TrivialQuestion.Categories;

public class QuestionSelector {

	private Map<Categories, List<Question>> categories;

	public QuestionSelector(List<Question> questions) {
		createMap(questions);
	}

	private void createMap(List<Question> questions) {

		initializeMap();

		for (Question q : questions) {
			switch (q.getCategory()) {
			case ART:
				categories.get(Categories.ART).add(q);
				break;
			case ENTERTAINMENT:
				categories.get(Categories.ENTERTAINMENT).add(q);
				break;
			case GEOGRAPHY:
				categories.get(Categories.GEOGRAPHY).add(q);
				break;
			case HISTORY:
				categories.get(Categories.HISTORY).add(q);
				break;
			case SCIENCE:
				categories.get(Categories.SCIENCE).add(q);
				break;
			case SPORT:
				categories.get(Categories.SPORT).add(q);
				break;
			}
		}
	}

	private void initializeMap() {
		categories = new HashMap<Categories, List<Question>>();
		for (Categories c : Categories.values())
			categories.put(c, new ArrayList<Question>());
	}

	public Map<Categories, List<Question>> getCategories() {
		return categories;
	}

	public void setCategories(Map<Categories, List<Question>> categories) {
		this.categories = categories;
	}
	
	public Question getQuestion(Categories category){
		List<Question> list = categories.get(category);
		return list.get((int) (Math.random() * list.size()));
	}

}
