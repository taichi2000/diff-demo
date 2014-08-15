package diffdemo.line;

import java.util.ArrayList;
import java.util.List;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

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

		String newText = anotherLine.getLineString();

		if (!_line.equals(newText)) {
			if (isNullOrEmpty(newText)) {
				result += "-";
			} else {
				List<String> listOriginal = createArrayList(_line);
				List<String> listNew = createArrayList(newText);

				Patch patch = DiffUtils.diff(listOriginal, listNew);

				List<Delta> deltas = patch.getDeltas();
				
				StringBuilder pluses = new StringBuilder();
				StringBuilder minuses = new StringBuilder();

				for (Delta delta : deltas) {
					switch (delta.getType()) {
					case CHANGE:
						pluses.append("+");
						minuses.append("-");
						break;

					case DELETE:
						minuses.append("-");
						break;

					case INSERT:
						pluses.append("+");
						break;

					default:
						break;
					}
				}

				result = pluses.append(minuses).toString();
			}
		}

		return result;
	}

	private ArrayList<String> createArrayList(String line) {
		ArrayList<String> list = new ArrayList<String>();

		list.add(line);

		return list;
	}

	private boolean isNullOrEmpty(String line) {
		return line == null || line.isEmpty();
	}

	@Override
	public String getLineString() {
		return _line;
	}
}
