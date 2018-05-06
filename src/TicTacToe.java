public class TicTacToe
{
	public static final int SIZE = 3; // Idea: pass in constructor for dynamic fields

	private final int[] fields = new int[SIZE * SIZE];
	private int currentPlayer = 1;
	private int currentTurn = 0;

	public void takeTurn(int fieldNumber)
	{
		if(fields[fieldNumber] != 0)
		{
			throw new IllegalArgumentException("Occupied " + fieldNumber);
		}
		fields[fieldNumber] = currentPlayer;
		switchPlayer();
		currentTurn++;
	}

	private void switchPlayer()
	{
		currentPlayer = 3 - currentPlayer;
	}

	public int parseInput(String input)
	{
		if(input.length() != 2)
		{
			return -1;
		}

		char lineInput = input.charAt(0);
		int line = lineInput - 'a';
		if (line < 0 || line >= SIZE)
		{
			return -2;
		}

		char columnInput = input.charAt(1);
		int column = columnInput - '1';
		if (column < 0 || column >= SIZE)
		{
			return -3;
		}

		return line * SIZE + column;
	}

	public boolean isFree(int fieldNumber)
	{
		return fields[fieldNumber] == 0;
	}

	public boolean isTurnLimitReached()
	{
		return currentTurn >= SIZE * SIZE;
	}

	public int[] getFields()
	{
		return fields;
	}

	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
}
