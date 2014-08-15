package diffdemo.line;

/**
 * Convenience class for create Line objects. A line could be instantiaded with
 * null, in which case it will return {@link NullLine}. If is empty text, it
 * will be {@link EmptyLine}
 */
public class LineFactory {
	private LineFactory() {

	}

	public static Line create(String text) {
		Line line = (text == null) ? NullLine.getInstace() : resolveLine(text);

		return line;
	}

	private static Line resolveLine(String text) {
		Line line = text.isEmpty() ? EmptyLine.getInstace() : new ConcreteLine(
				text);

		return line;
	}

}
