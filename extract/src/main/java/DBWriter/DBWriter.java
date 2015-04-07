package DBWriter;

import java.util.List;

import Model.Question;

public interface DBWriter {

	void insertQuestions(List<Question> trivialQuestions);
}
