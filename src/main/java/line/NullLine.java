package line;

/**
 * Represents a Null Line
 *
 */
public class NullLine implements Line {
	private static NullLine _instance = new NullLine();

	private NullLine() {

	}

	public static Line getInstace() {
		return _instance;
	}

	@Override
	public String compareTo(Line anotherLine) {
		String result = (anotherLine == null) ? "" : "+";

		return result;
	}

	@Override
	public String getLineString() {
		return null;
	}
}
