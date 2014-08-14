package diffdemo;

import java.io.IOException;

import org.junit.Test;

public class DiffRunnerTest {

	@Test
	public void testDiff() throws IOException {
		String filePath1 = "/old.txt";
		String filePath2 = "/new.txt";

		DiffRunner diffRunner = new DiffRunner(filePath1, filePath2);

		String diffResult = diffRunner.diff();

		System.out.println("RESULT IS:");
		System.out.println("==========");
		System.out.println(diffResult);
	}

}
