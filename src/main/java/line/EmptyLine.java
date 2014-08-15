package line;

/**
 * Represents an Empty Line
 *
 */
public class EmptyLine implements Line {
	private static EmptyLine _instance = new EmptyLine();

	private EmptyLine() {

	}

	public static Line getInstace() {
		return _instance;
	}

	@Override
	public String compareTo(Line anotherLine) {
		String text = anotherLine.getLineString();

		String result = "";

		if ("".equals(text) == false) {
			result = (text == null) ? "-" : "+";
		}

		return result;
	}

	@Override
	public String getLineString() {
		return "";
	}
}
