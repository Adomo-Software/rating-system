import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RateValueTableTest {

	private RateValueTable rateValueTable;

	@BeforeEach
	public void setUp() {
		rateValueTable = new RateValueTable();
	}

	@Test
	public void testRate() {
		rateValueTable.setColumn("Row1", 3, 2, "C", "B", "1 i lose");
		rateValueTable.setColumn("Row2", 1, 4, "A", "D", "2  i win");

		rateValueTable.rate();
		rateValueTable.printTable();
		assertEquals(8, rateValueTable.sums.values().toArray()[0]);
		assertEquals(7, rateValueTable.sums.values().toArray()[1]);
		Set<Map.Entry<String, Map<Integer, Object>>> keySet = rateValueTable.sums.keySet();
		ArrayList<Map.Entry<String, Map<Integer, Object>>> keyList = new ArrayList<>(keySet);
		assertEquals("Row2", keyList.get(0).getKey());
	}
}