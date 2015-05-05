package model;

import model.model.TrivialQuestion.Categories;

public class Utils {
	
	private static final String SPORT = "sport";
	private static final String SCIENCE = "science";
	private static final String ART = "art";
	private static final String HISTORY = "history";
	private static final String ENTERTAINMENT = "entertainment";
	private static final String GEOGRAPHY = "geography";

	public static Categories getCategory(String attribute) {
		switch (attribute.toLowerCase()) {
		case GEOGRAPHY:
			return Categories.GEOGRAPHY;
		case ENTERTAINMENT:
			return Categories.ENTERTAINMENT;
		case HISTORY:
			return Categories.HISTORY;
		case ART:
			return Categories.ART;
		case SCIENCE:
			return Categories.SCIENCE;
		case SPORT:
			return Categories.SPORT;
		default:
			return null;
		}
	}
	
	public static String getStringCategory(Categories category) {
		switch (category) {
		case GEOGRAPHY:
			return GEOGRAPHY;
		case ENTERTAINMENT:
			return ENTERTAINMENT;
		case HISTORY:
			return HISTORY;
		case ART:
			return ART;
		case SCIENCE:
			return SCIENCE;
		case SPORT:
			return SPORT;
		default:
			return null;
		}
	}
}
