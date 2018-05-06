public class TextFieldPrinter implements FieldPrinter
{
	private final int size;

	public TextFieldPrinter(int size)
	{
		this.size = size;
	}

	public String print(int[] fields)
	{
		if(fields.length != size * size)
		{
			throw new IllegalArgumentException("field dimension not " + (size * size));
		}

		StringBuilder sb = new StringBuilder();
		for(int lineIndex = 0; lineIndex < size * 2 - 1; lineIndex++)
		{
			createLine(fields, lineIndex, sb);
		}
		return sb.toString();
	}

	private void createLine(int[] fields, int lineIndex, StringBuilder sb)
	{
		if(lineIndex % 2 == 1)
		{
			sb.append("-+-+-");
		}
		else
		{
			for(int colIndex = 0; colIndex < size * 2 - 1; colIndex++)
			{
				createColumn(fields, lineIndex, colIndex, sb);
			}
		}
		sb.append('\n');
	}

	private void createColumn(int[] fields, int lineIndex, int colIndex, StringBuilder sb)
	{
		if(colIndex % 2 == 1)
		{
			sb.append('|');
		}
		else
		{
			int fieldNumber = (lineIndex / 2) * size + colIndex / 2;
			int fieldValue = fields[fieldNumber];
			char fieldSymbol = mapToSymbol(fieldValue);
			sb.append(fieldSymbol);
		}
	}

	private char mapToSymbol(int fieldValue)
	{
		return SYMBOL_BY_FIELD_VALUE[fieldValue];
	}

	@Override
	public char currentPlayerName(int currentPlayer)
	{
		return SYMBOL_BY_FIELD_VALUE[currentPlayer];
	}
}
