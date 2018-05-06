import java.util.*;

public class GameLoop
{
	private final TicTacToe ticTacToe = new TicTacToe();
	private final FieldPrinter fieldPrinter = new TextFieldPrinter(TicTacToe.SIZE);

	public void gameLoop()
	{
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println(fieldPrinter.print(ticTacToe.getFields()));
			System.out.println("Current Player: " + fieldPrinter.currentPlayerName(ticTacToe.getCurrentPlayer()));

			// TODO describe format of input,
			//   or maybe list possible positions,
			//   or print coordinates in empty fields
			String positionText = input.next();
			int position = ticTacToe.parseInput(positionText);
			if(position < 0)
			{
				System.out.println("Illegal Input \"" + positionText + "\"");
				continue;
			}
			if(!ticTacToe.isFree(position))
			{
				System.out.println("Occupied \"" + positionText + "\"");
				continue;
			}
			ticTacToe.takeTurn(position);
			// TODO winner check
			if(ticTacToe.isTurnLimitReached())
			{

				System.out.println("No Winner");
				break;
			}
		}
		System.out.println(fieldPrinter.print(ticTacToe.getFields()));
	}

	public static void main(String[] args)
	{
		new GameLoop().gameLoop();
	}
}