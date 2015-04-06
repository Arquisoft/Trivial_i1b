import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import Interface.InitialWindow;

public class InitialWindowTest {

	private  InitialWindow window;
	private Color blue=new Color(0, 0, 139);
	private void initialize() {
		window=new InitialWindow();
	}

	@Test
	public void test() {
		initialize();

		assertEquals(blue, window.pnFondo.getBackground());
		window.getBtnRed().doClick();
		assertEquals(Color.RED, window.pnFondo.getBackground());
	}

}
