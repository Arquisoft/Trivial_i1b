package DBWriter;

import Model.TrivialQuestion.Categories;

public class Utility {
	
	public static String getCategory(Categories category) {
		switch (category) {
		case ART:
			return "art";
		case ENTERTAINMENT:
			return "entertainment";
		case HISTORY:
			return "history";
		case SCIENCE:
			return "science";
		case SPORT:
			return "sport";
		case GEOGRAPHY:
			return "geography";
		default:
			return null;
		}
	}

}
