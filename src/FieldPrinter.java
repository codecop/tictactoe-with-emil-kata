public interface FieldPrinter
{
	char[] SYMBOL_BY_FIELD_VALUE = new char[]{' ', 'X', 'O'};

	String print(int[] fields);

	default char currentPlayerName(int currentPlayer)
	{
		return SYMBOL_BY_FIELD_VALUE[currentPlayer];
	}
}