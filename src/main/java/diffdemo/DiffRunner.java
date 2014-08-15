package diffdemo;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Utility class to create a diff report
 *
 */
public class DiffRunner {
	private MyFileReader _originalFileReader;
	private MyFileReader _newFileReader;

	public DiffRunner(String originalFilePath, String newFilePath)
			throws FileNotFoundException {
		_originalFileReader = new MyFileReader(originalFilePath);
		_newFileReader = new MyFileReader(newFilePath);
	}

	/**
	 * Creates a diff report from comparing two files
	 * 
	 * @return diff report
	 * @throws IOException
	 */
	public String diff() throws IOException {
		String diffReport = FileComparator.compare(_originalFileReader,
				_newFileReader);

		return diffReport;
	}
}
