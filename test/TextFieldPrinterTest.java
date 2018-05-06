import static org.junit.Assert.*;
import org.junit.*;

public class TextFieldPrinterTest
{

	private FieldPrinter game = new TextFieldPrinter(3);

	@Test
	public void shouldDisplayStartingBoard()
	{
		String expected = " | | \n" + //
		                  "-+-+-\n" + //
				          " | | \n" + //
						  "-+-+-\n" + //
				          " | | \n";

		int[] startingBoard = new int[9];
		String actual = game.print(startingBoard);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldDisplayBoardWithBothPlayers()
	{
		String expected = "O| | \n" + //
						  "-+-+-\n" + //
					  	  " |X| \n" + //
						  "-+-+-\n" + //
						  " | | \n";

		String actual = game.print(new int[]{2, 0, 0, 0, 1, 0, 0, 0, 0});

		assertEquals(expected, actual);
	}
}
