package diffdemo;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests diff reports generated
 */
public class DiffRunnerTest {

	@Test
	public void testDiff() throws IOException {
		String originalFilePath = "/old.txt";
		String newFilePath = "/new.txt";

		DiffRunner diffRunner = new DiffRunner(originalFilePath, newFilePath);

		String diffReport = diffRunner.diff();

		System.out.println("RESULT IS:");
		System.out.println("==========");
		System.out.println(diffReport);
	}

}
