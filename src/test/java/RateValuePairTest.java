import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RateValuePairTest {
	@Test
	public void testSetRate() {
		RateValuePair pair = new RateValuePair("TestValue");
		pair.setRate(10);

		assertEquals(10, pair.getRate());
	}

	@Test
	public void testToString() {
		RateValuePair pair = new RateValuePair("TestValue");
		pair.setRate(5);

		assertEquals("TestValue(5)", pair.toString());
	}

	@Test
	public void testCompareTo() {
		RateValuePair pair1 = new RateValuePair("A");
		RateValuePair pair2 = new RateValuePair("B");

		assertEquals(-1, pair1.compareTo(pair2));

		pair1 = new RateValuePair("B");
		pair2 = new RateValuePair("A");
		assertEquals(1, pair1.compareTo(pair2));

		pair1 = new RateValuePair("A");
		pair2 = new RateValuePair("A");
		assertEquals(0, pair1.compareTo(pair2));
	}

	@Test
	public void testInvalidComparison() {
		RateValuePair pair1 = new RateValuePair("Test");

		assertThrows(ClassCastException.class, () -> {
			pair1.compareTo(new RateValuePair(123));
		});
	}
}