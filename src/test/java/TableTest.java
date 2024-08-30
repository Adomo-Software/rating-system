import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    private Table table;

    @BeforeEach
    public void setUp() {
        table = new Table();
    }

    @Test
    public void testAddRow() {
        table.addRow("Row1");
        assertTrue(table.getRows().containsKey("Row1"));
        assertEquals(0, table.getRows().get("Row1").size());
    }

    @Test
    public void testAddColumnWithRowTracking() {
        table.addRow("Row1");
        table.addColumn("Row1", "Value1");
        table.addColumn("Row1", "Value2");

        assertEquals(2, table.getRow("Row1").size());
        assertEquals("Value1", table.getRow("Row1").get(0));
        assertEquals("Value2", table.getRow("Row1").get(1));
    }

    @Test
    public void testSetColumn() {
        table.setColumn("Row1", "Value1", "Value2", "Value3");

        assertEquals(3, table.getRow("Row1").size());
        assertEquals("Value1", table.getRow("Row1").get(0));
        assertEquals("Value2", table.getRow("Row1").get(1));
        assertEquals("Value3", table.getRow("Row1").get(2));
    }

    @Test
    public void testColumnTrackingMultipleRows() {
        table.addRow("Row1");
        table.addRow("Row2");
        table.addColumn("Row1", "Value1");
        table.addColumn("Row1", "Value2");
        table.addColumn("Row2", "Value3");

        assertEquals(2, table.getRow("Row1").size());
        assertEquals(1, table.getRow("Row2").size());
        assertEquals("Value1", table.getRow("Row1").get(0));
        assertEquals("Value2", table.getRow("Row1").get(1));
        assertEquals("Value3", table.getRow("Row2").get(0));
    }

    @Test
    public void testOverrideAddRow() {
        table.addRow("Row1");
        table.addColumn("Row1", "Value1");
        table.addRow("Row1");
        table.addColumn("Row1", "Value2");

        HashMap<String, String> expected = new HashMap<>();
        expected.put("Row1", "Value1");
        // Value1 doesn't get overwritten to Value2 because of how HashMap works.
        // could add delRow function for this.
        assertEquals(expected, table.getColumn(0));
    }

    @Test
    public void testEmptyRows() {
        table.addRow("Row1");
        table.addRow("Row2");

        assertEquals(0, table.getRow("Row1").size());
        assertEquals(0, table.getRow("Row2").size());
    }

    @Test
    public void testEmptyColumns() {
        table.addRow("Row1");
        Map<String, Object> column = table.getColumn(0);
        assertTrue(column.isEmpty());
    }
}
