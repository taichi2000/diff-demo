package diffdemo;

import java.io.IOException;

public class Comparator {

	public static String compare(MyFileReader oldFile, MyFileReader newFile)
			throws IOException {

		StringBuilder comparationBuilder = new StringBuilder();
		Line oldLine = oldFile.next();

		while (oldLine.isNotEof()) {
			Line newLine = newFile.next();

			if (newLine.isNotEof()) {
				String lineDiff = oldLine.compare(newLine);
				String resultLine = String.format("Line no: %3d. Diff: %s \n",
						oldFile.lineNumber(), lineDiff);

				comparationBuilder.append(resultLine);
			} else { // EOF
				break;
			}

			oldLine = oldFile.next();
		}

		// didn't do

		String comparation = comparationBuilder.toString();

		return comparation;
	}

}
