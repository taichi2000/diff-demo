package diffdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import diffdemo.line.Line;
import diffdemo.line.LineFactory;

public class MyFileReader {
	private BufferedReader _reader;
	private int _lineNumber = 0;
	private boolean _eof = false;

	public MyFileReader(String filePath) throws FileNotFoundException {
		_reader = createFileReader(filePath);
	}

	private BufferedReader createFileReader(String filePath)
			throws FileNotFoundException {
		return new BufferedReader(new FileReader(MyFileReader.class
				.getResource(filePath).getFile()));
	}

	public Line readLine() throws IOException {
		String text = _reader.readLine();

		Line line = updateStateAndCreateLine(text);

		return line;
	}

	private Line updateStateAndCreateLine(String text) {
		Line line = createLine(text);

		setEOFReachedIfNull(text);

		updateLineNumber();

		return line;
	}

	private void setEOFReachedIfNull(String text) {
		if (text == null)
			_eof = true;
	}

	private void updateLineNumber() {
		if (isNotEOF())
			_lineNumber++;
	}

	public boolean isNotEOF() {
		return !_eof;
	}

	private Line createLine(String text) {
		Line line = LineFactory.create(text);

		return line;
	}

	public int currentLineNumber() {
		return _lineNumber;
	}
}
