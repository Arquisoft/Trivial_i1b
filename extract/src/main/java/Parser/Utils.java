package Parser;

import Model.TrivialQuestion.Categories;

public class Utils {
	
	public static Categories getCategory(String attribute) {
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
	
	public static String getStringCategory(Categories category) {
		switch (category) {
		case GEOGRAPHY:
			return "geography";
		case ENTERTAINMENT:
			return "entertainment";
		case HISTORY:
			return "history";
		case ART:
			return "art";
		case SCIENCE:
			return "science";
		case SPORT:
			return "sport";
		default:
			return null;
		}
	}
}
