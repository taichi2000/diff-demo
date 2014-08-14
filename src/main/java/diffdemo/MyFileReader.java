package diffdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

	private BufferedReader _fileReader;
	private int _lineNumber = 0;

	public MyFileReader(String filePath) throws FileNotFoundException {
		_fileReader = new BufferedReader(new FileReader(MyFileReader.class
				.getResource(filePath).getFile()));
	}

	public Line next() throws IOException {
		String lineRead = _fileReader.readLine();

		_lineNumber++;

		return new Line(lineRead);
	}

	public int lineNumber() {
		return _lineNumber;
	}
}
