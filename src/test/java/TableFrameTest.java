import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TableFrameTest {

	private TableFrame tableFrame;

	@BeforeEach
	public void setUp() {
		tableFrame = new TableFrame();
	}

	@Test
	public void testAddRow() {
		tableFrame.addRow("Row1");
		assertTrue(tableFrame.getRows().containsKey("Row1"));
		assertEquals(0, tableFrame.getRows().get("Row1").size());
	}

	@ParameterizedTest
	@CsvSource({
		"1, Row1, Value1",
		"2, Row2, Value2",
		"3, Row3, Value3"
	})
	public void testAddColumn(int column, String row, String value) {
		tableFrame.addColumn(column, row, value);
		assertTrue(tableFrame.getRows().containsKey(row));
		assertEquals(1, tableFrame.getRow(row).size());
		assertEquals(value, tableFrame.getRow(row).get(column));

		assertTrue(tableFrame.getColumns().containsKey(column));
		assertEquals(1, tableFrame.getColumn(column).size());
		assertEquals(value, tableFrame.getColumn(column).get(row));
	}

	private static Stream<Arguments> provideDataForGetRow() {
		return Stream.of(
			Arguments.of("Row1", 2, new Object[]{"Value1", "Value2"}),
			Arguments.of("Row2", 3, new Object[]{"A", "B", "C"})
		);
	}
	@ParameterizedTest
	@MethodSource("provideDataForGetRow")
	public void testGetRow(String rowName, int expectedSize, Object[] expectedValues) {
		tableFrame.addRow(rowName);
		for (int i = 0; i < expectedSize; i++) {
			tableFrame.addColumn(i + 1, rowName, expectedValues[i]);
		}

		Map<Integer, Object> row = tableFrame.getRow(rowName);
		assertEquals(expectedSize, row.size());
		for (int i = 0; i < expectedSize; i++) {
			assertEquals(expectedValues[i], row.get(i + 1));
		}
	}



	@Test
	public void testGetColumn() {
		tableFrame.addColumn(1, "Row1", "Value1");
		tableFrame.addColumn(1, "Row2", "Value2");

		Map<String, Object> column = tableFrame.getColumn(1);
		assertEquals(2, column.size());
		assertEquals("Value1", column.get("Row1"));
		assertEquals("Value2", column.get("Row2"));
	}

	@Test
	public void testGetEmptyRow() {
		Map<Integer, Object> row = tableFrame.getRow("NonExistentRow");
		assertTrue(row.isEmpty());
	}

	@Test
	public void testGetEmptyColumn() {
		Map<String, Object> column = tableFrame.getColumn(99);
		assertTrue(column.isEmpty());
	}

	@Test
	public void testPrintTable() {
		tableFrame.addColumn(1, "Row1", "Value1");
		tableFrame.addColumn(2, "Row1", "Value2");
		tableFrame.addColumn(1, "Row2", "Value3");

		tableFrame.printTable();
	}

	@Test
	public void testColumnIndexZero() {
		tableFrame.addColumn(0, "Row1", "Value1");
		assertEquals("Value1", tableFrame.getRow("Row1").get(0));
		assertEquals("Value1", tableFrame.getColumn(0).get("Row1"));
	}

	@Test
	public void testAddingDuplicateValues() {
		tableFrame.addColumn(1, "Row1", "Value1");
		tableFrame.addColumn(1, "Row1", "NewValue");

		assertEquals("Value1", tableFrame.getRow("Row1").get(1));
		assertEquals("Value1", tableFrame.getColumn(1).get("Row1"));
	}
}
