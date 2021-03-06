package Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Question;
import Model.TrivialQuestion;

public class GIFTParser implements Parser {

	private List<Question> questions;
	private BufferedReader reader;

	public GIFTParser(String file) {
		try {
			reader = new BufferedReader(new FileReader(file));
			questions = new ArrayList<Question>();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void parse() {
		try {
			String line = "";
			String category = "";
			String question = "";
			List<String> answers = new ArrayList<String>();
			int correctAnswer = 0;
			int counter = 0;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("::")) {
					category = line.split(":")[2].trim();
					question = line.split(":")[4].replace("{", "").trim();
				} else if (line.startsWith("~")) {
					answers.add(line.replace("~", "").trim());
					counter++;
				} else if (line.startsWith("=")) {
					answers.add(line.replace("=", "").trim());
					correctAnswer = counter;
				} else if (line.startsWith("}")) {
					questions.add(new TrivialQuestion(Utils.getCategory(category), question,
							new ArrayList<String>(answers), correctAnswer));
					question = "";
					answers.clear();
					correctAnswer = 0;
					counter = 0;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Question> getQuestions() {
		parse();
		return questions;
	}

}
