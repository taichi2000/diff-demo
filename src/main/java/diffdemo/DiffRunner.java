package diffdemo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DiffRunner {
	private MyFileReader _oldFile;
	private MyFileReader _newFile;

	public DiffRunner(String oldFile, String newFile)
			throws FileNotFoundException {
		_oldFile = new MyFileReader(oldFile);
		_newFile = new MyFileReader(newFile);
	}

	public String diff() throws IOException {
		String diffResult = Comparator.compare(_oldFile, _newFile);

		return diffResult;
	}
}
