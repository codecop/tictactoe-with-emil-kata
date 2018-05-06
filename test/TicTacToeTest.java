import static org.junit.Assert.*;
import org.junit.*;

public class TicTacToeTest
{
	private TicTacToe game = new TicTacToe();

	@Test
	public void shouldSetGivenFieldForCurrentPlayer()
	{
		int[] expectedFields = new int[]{0, 0, 0, //
 										 0, 1, 0, //
 										 0, 0, 0};

		game.takeTurn(4);

		int[] actualFields = game.getFields();
		assertArrayEquals(expectedFields, actualFields);
	}

	@Test
	public void shouldSetGivenFieldForPlayer2()
	{
		int[] expectedFields = new int[]{0, 0, 1, //
										 0, 0, 2, //
										 0, 0, 0};

		game.takeTurn(2);
		game.takeTurn(5);

		int[] actualFields = game.getFields();
		assertArrayEquals(expectedFields, actualFields);
	}

	@Test
	public void shouldCheckIfFieldIsFree()
	{
		game.takeTurn(2);

		assertTrue(game.isFree(0));
		assertFalse(game.isFree(2));
	}

	@Test
	public void shouldParseValidInput()
	{
		String input = "a3";
		int expected = 2;

		int actual = game.parseInput(input);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldNotParseInvalidInputLength()
	{
		String input = "a33";
		int expected = -1;

		int actual = game.parseInput(input);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldNotParseInvalidInputLine()
	{
		String input = "f3";
		int expected = -2;

		int actual = game.parseInput(input);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldNotParseInvalidInputColumn()
	{
		String input = "a0";
		int expected = -3;

		int actual = game.parseInput(input);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReachTurnLimit()
	{
		for(int i = 0; i < 9; i++)
		{
			assertFalse(game.isTurnLimitReached());
			game.takeTurn(i);
		}
		assertTrue(game.isTurnLimitReached());
	}
}
