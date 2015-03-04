package Trivial_i1b.Trivial_i1b;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Trivial_i1b.Trivial_i1b.Model.Question;
import Trivial_i1b.Trivial_i1b.Parser.GIFTParser;

public class GIFTParserTest {

	private List<Question> questions;

	private void initialize() {
		questions = new GIFTParser("src/test/resources/test.gift").getQuestions();
	}

	@Test
	public void test() {
		initialize();

		assertEquals("First Question", questions.get(0).getQuestion());
		String[] answers = new String[] { "Good answer", "Wrong answer",
				"Another Wrong answer" };
		for (int i = 0; i < answers.length; i++)
			assertEquals(answers[i], questions.get(0).getAnswers().get(i));

		assertEquals("Second Question", questions.get(1).getQuestion());
		answers = new String[] {
				"Las modificaciones son posibles, pero con restricciones",
				"Se permite la redistribución binaria",
				"En caso de redistribución binaria, es obligada la redistribución de los fuentes" };
		for (int i = 0; i < answers.length; i++)
			assertEquals(answers[i], questions.get(1).getAnswers().get(i));

		assertEquals("Third Question", questions.get(2).getQuestion());
		answers = new String[] {
				"Un autor no puede distribuir varias obras con distintas licencias",
				"Shareware es una forma de licenciar el software comercial",
				"GPL y BSD permiten la redistribución fuente y binaria" };
		for (int i = 0; i < answers.length; i++)
			assertEquals(answers[i], questions.get(2).getAnswers().get(i));
	}

}
