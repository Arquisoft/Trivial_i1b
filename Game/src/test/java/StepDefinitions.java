import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import logic.model.Die;
import logic.model.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


@SuppressWarnings("deprecation")
public class StepDefinitions {
	
	public List<Integer> rolls;
	public Player player = new Player(null, 6);

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
	
	@Given("^he gets (\\d+) wedges$")
	public void he_gets_wedges(int arg1) throws Throwable {
	   for (int i = 0; i <= arg1; i++) {
		player.getWedges()[i] = true;
	}
	}

	@Then("^he does not have all the questions answered$")
	public void he_does_not_have_all_the_questions_answered() throws Throwable {
	    Assert.assertFalse(player.allQuestionsMatched());
	}

	@Then("^he does have all the questions answered$")
	public void he_does_have_all_the_questions_answered() throws Throwable {
		 Assert.assertTrue(player.allQuestionsMatched());
	}
	
//	@Given("^he is in the starting position$")
//	public void he_is_in_the_starting_position() throws Throwable {
//	    Assert.assertTrue(player.getPosition().getWalk()==0);
//	    Assert.assertTrue(player.getPosition().getIndex()==1);
//	}
//
//	@Then("^we can assign him a position and check he is there$")
//	public void we_can_assign_him_a_position_and_check_he_is_there() throws Throwable {
//	    Position pos = new Position(3, 8);
//	}
//
//	@Given("^he is not in the starting position$")
//	public void he_is_not_in_the_starting_position() throws Throwable {
//	    // Express the Regexp above with the code you wish you had
//	    throw new PendingException();
//	}
}
