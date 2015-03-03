package es.uniovi.seti.Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.uniovi.seti.Model.Question;
import es.uniovi.seti.Model.TrivialQuestion;

public class XMLParser implements Parser {

	private List<Question> questions;
	private Document doc;

	public XMLParser(String file) {
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new File(file));
			questions = new ArrayList<Question>();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private void parse() {
		NodeList list = doc.getElementsByTagName("question");
		List<String> answers;
		int correctAnswer = -1;
		for(int i = 0; i < list.getLength(); i++)
		{
			Element node = (Element) list.item(i);
			answers = new ArrayList<String>();
			
			NodeList answerList = node.getElementsByTagName("answer");
			for(int j = 0; j < answerList.getLength(); j++)
			{
				Element answer = (Element) answerList.item(j);
				answers.add(answer.getAttribute("value"));
				if(answer.getAttribute("correctAnswer") != null)
					correctAnswer = j;
			}
			questions.add(new TrivialQuestion(node.getAttribute("question"), answers, correctAnswer));
		}
	}

	@Override
	public List<Question> getQuestions() {
		parse();
		return questions;
	}

}
