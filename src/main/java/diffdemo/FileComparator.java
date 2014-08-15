package diffdemo;

import java.io.IOException;

import diffdemo.line.Line;

/**
 * Compares two files and creates text report showing number of differences:
 * <ul>
 * <li>(+) new changes</li>
 * <li>(-) deletions</li>
 * <li>( ) no change</li>
 */
public class FileComparator {

	private static final String HEAD = "Line| Original | New      |Diff";
	private static final String BORDER = "===============================";
	private static final String LINE_FORMAT = "%03d |%10s|%10s|%s\n";

	public static String compare(MyFileReader originalFile, MyFileReader newFile)
			throws IOException {
		StringBuilder reportBuilder = new StringBuilder(HEAD).append("\n")
				.append(BORDER).append("\n");

		Line originalLine = originalFile.readLine();

		while (originalFile.isNotEOF()) {
			if (newFile.isNotEOF()) {
				Line newLine = newFile.readLine();

				String lineDiff = originalLine.compareTo(newLine);

				String resultLine = getLineReport(originalFile, originalLine,
						newLine, lineDiff);

				reportBuilder.append(resultLine);
			} else { // EOF
				break;
			}

			originalLine = originalFile.readLine();
		}

		// didn't do

		String report = reportBuilder.toString();

		return report;
	}

	private static String getLineReport(MyFileReader originalFile,
			Line originalLine, Line newLine, String diff) {
		int lineNumber = originalFile.currentLineNumber();
		String original = originalLine.getLineString();
		String newText = newLine.getLineString();

		return String.format(LINE_FORMAT, lineNumber, original, newText, diff);
	}

}
