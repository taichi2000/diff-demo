package diffdemo.line;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LineFactoryTest {

	@Test
	public void testCreateNullLine() {
		createAndVerifyType(null, NullLine.class);
	}

	private void createAndVerifyType(String text,
			Class<? extends Line> lineClass) {
		Line line = LineFactory.create(text);

		assertNotNull(line);
		assertTrue(lineClass.equals(line.getClass()));
	}

	@Test
	public void testCreateEmptyLine() {
		createAndVerifyType("", EmptyLine.class);
	}

	@Test
	public void testCreateConcreteLine() {
		createAndVerifyType("hello", ConcreteLine.class);
	}

}
