package diffdemo;

public class Line {

	private String _line;

	public Line(String lineRead) {
		_line = lineRead;
	}

	public String compare(Line newLine) {
		String result = "";

		if (_line.compareTo(newLine._line) == 0) {
			// nothing to do
		} else {
			result = result + "+++ ---";
		}

		return result;
	}

	public boolean isNotEof() {
		return _line != null;
	}
}
