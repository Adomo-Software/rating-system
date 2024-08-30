import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

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

	@Test
	public void testAddColumn() {
		tableFrame.addColumn(1, "Row1", "Value1");
		assertTrue(tableFrame.getRows().containsKey("Row1"));
		assertEquals(1, tableFrame.getRow("Row1").size());
		assertEquals("Value1", tableFrame.getRow("Row1").get(1));

		assertTrue(tableFrame.getColumns().containsKey(1));
		assertEquals(1, tableFrame.getColumn(1).size());
		assertEquals("Value1", tableFrame.getColumn(1).get("Row1"));
	}

	@Test
	public void testGetRow() {
		tableFrame.addRow("Row1");
		tableFrame.addColumn(1, "Row1", "Value1");
		tableFrame.addColumn(2, "Row1", "Value2");

		Map<Integer, Object> row = tableFrame.getRow("Row1");
		assertEquals(2, row.size());
		assertEquals("Value1", row.get(1));
		assertEquals("Value2", row.get(2));
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
