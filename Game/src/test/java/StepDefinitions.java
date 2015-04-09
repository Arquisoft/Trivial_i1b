import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import logic.model.Die;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


@SuppressWarnings("deprecation")
public class StepDefinitions {
	
	public List<Integer> rolls;

	@Given("^roll the dice (\\d+) time$")
	public void roll_the_dice_time(int arg1) throws Throwable {
	    rolls = new ArrayList<Integer>();
	    for (int i = 0; i <= arg1; i++) {
			rolls.add(Die.drop());
		}
	}

	@Then("^we should obtain (\\d+) numbers > (\\d+) and < (\\d+)$")
	public void we_should_obtain_numbers_and_(int arg1, int arg2, int arg3) throws Throwable {
	    for (int i = 0; i <= arg1; i++) {
			Assert.assertTrue(rolls.get(i) > arg2);
			Assert.assertTrue(rolls.get(i) < arg3);
		}
	}
}
