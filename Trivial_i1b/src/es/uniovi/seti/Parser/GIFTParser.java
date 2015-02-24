package es.uniovi.seti.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.seti.Model.Question;
import es.uniovi.seti.Model.TrivialQuestion;

public class GIFTParser implements Parser{
	
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
			while((line = reader.readLine()) != null){
				System.out.print(line);
				//this.questions.add(new TrivialQuestion(question, answers, positionTrue);
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
