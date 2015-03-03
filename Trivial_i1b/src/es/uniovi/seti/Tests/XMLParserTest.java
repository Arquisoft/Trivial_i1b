package es.uniovi.seti.Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.seti.Model.Question;
import es.uniovi.seti.Model.TrivialQuestion;
import es.uniovi.seti.Parser.Parser;
import es.uniovi.seti.Parser.XMLParser;

public class XMLParserTest {
	
	List<Question> expectedValues = new ArrayList<Question>();

	@Before
	public void setUp() throws Exception {
		List<String> values = new ArrayList<String>();
		values.add("0");
		values.add("1");
		values.add("2");
		values.add("3");
		expectedValues.add(new TrivialQuestion("What is the position of this question in the list?", new ArrayList<String>(values), 0));
		values = new ArrayList<String>();
		values.add("Red Hot Chili Peppers");
		values.add("Metallica");
		values.add("Rage Against The Machine");
		values.add("Lynyrd Skynyrd");
		expectedValues.add(new TrivialQuestion("Which band plays the song 'Wet Sand'?", new ArrayList<String>(values), 0));
	}

	@Test
	public void test() {
		Parser xmlParser = new XMLParser("test.xml");
		List<Question> returnedValues = xmlParser.getQuestions();
		for (int i = 0; i < expectedValues.size(); i++) {
			assertTrue(expectedValues.get(i).getQuestion().equals(returnedValues.get(i).getQuestion()));
			for(int j = 0; j < expectedValues.get(i).getAnswers().size(); j++)
			{
				assertTrue(expectedValues.get(i).getAnswers().get(j).equals(returnedValues.get(i).getAnswers().get(j)));
			}
		}
	}

}
