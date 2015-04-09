package Parser;

import Model.TrivialQuestion.Categories;

public abstract class AbstractParser implements Parser{

	protected Categories getCategory(String attribute) {
		switch (attribute.toLowerCase()) {
		case "geography":
			return Categories.GEOGRAPHY;
		case "entertainment":
			return Categories.ENTERTAINMENT;
		case "history":
			return Categories.HISTORY;
		case "art":
			return Categories.ART;
		case "science":
			return Categories.SCIENCE;
		case "sport":
			return Categories.SPORT;
		default:
			return null;
		}
	}
	
}
