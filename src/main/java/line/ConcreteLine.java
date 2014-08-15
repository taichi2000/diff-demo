package line;

public class ConcreteLine implements Line {
	public class NullTextException extends LineException {
		private static final long serialVersionUID = 8748073389658469188L;

	}

	private String _line;

	public ConcreteLine(String line) {
		if (line == null) {
			throw new NullTextException();
		}

		_line = line;
	}

	@Override
	public String compareTo(Line anotherLine) {
		String result = "";

		String line = anotherLine.getLineString();

		if (!_line.equals(line)) {
			if (isNullOrEmpty(line)) {
				result += "-";
			} else {

				// result = aplicar estrategia de diff aqui
			}
		}

		return result;
	}

	private boolean isNullOrEmpty(String line) {
		return line == null || line.isEmpty();
	}

	@Override
	public String getLineString() {
		return _line;
	}
}
