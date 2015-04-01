import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Model.Question;
import Parser.GIFTParser;
import Interface.InitialWindow;

public class GIFTParserTest {

	private  InitialWindow window;
	private Color blue=new Color(0, 0, 139);
	private void initialize() {
		window=new InitialWindow();
	}

	@Test
	public void test() {
		initialize();

		assertEquals(blue, pnFondo.getBackground());
		btnRed.doClick();
		assertEquals(Color.RED, pnFondo.getBackground());
	}

}
