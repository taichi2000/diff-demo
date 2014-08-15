package diffdemo.line;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

import diffdemo.line.ConcreteLine;
import diffdemo.line.EmptyLine;
import diffdemo.line.NullLine;
import diffdemo.line.ConcreteLine.NullTextException;

public class ConcreteLineTest {

	private ConcreteLine _line;

	@Before
	public void setUp() {
		_line = new ConcreteLine("hello");
	}

	@Test(expected = NullTextException.class)
	public void testConcreteLineConstructorThrowsException() {
		new ConcreteLine(null);
	}

	@Test
	public void testConcreteLineConstructor() {
		assertNotNull(_line);
	}

	@Test
	public void testCompareToEquals() {
		ConcreteLine anotherLine = new ConcreteLine("hello");

		assertEquals("", _line.compareTo(anotherLine));
	}

	@Test
	public void testCompareToNonEquals() {
		ConcreteLine anotherLine = new ConcreteLine("bye");

		assertNotSame("", _line.compareTo(anotherLine));
	}

	@Test
	public void testCompareToEmpty() {
		assertNotSame("", _line.compareTo(EmptyLine.getInstace()));

	}

	@Test
	public void testCompareToNull() {
		assertNotSame("", _line.compareTo(NullLine.getInstace()));
	}

	@Test
	public void testGetLineString() {
		ConcreteLine concreteLine = new ConcreteLine("hello");

		assertEquals("hello", concreteLine.getLineString());
	}

}
