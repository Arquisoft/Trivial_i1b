package Trivial_i1b.Trivial_i1b.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Trivial_i1b.Trivial_i1b.Model.Question;
import Trivial_i1b.Trivial_i1b.Model.TrivialQuestion;

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
			String question = "";
			List<String> answers = new ArrayList<String>();
			int correctAnswer = 0;
			int counter = 0;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("::")) {
					question = line.split(":")[4].replace("{", "").trim();
				} else if (line.startsWith("~")) {
					answers.add(line.replace("~", "").trim());
					counter++;
				} else if (line.startsWith("=")) {
					answers.add(line.replace("=", "").trim());
					correctAnswer = counter;
				} else if (line.startsWith("}")) {
					questions.add(new TrivialQuestion(question,
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

	@Override
	public List<Question> getQuestions() {
		parse();
		return questions;
	}

}
