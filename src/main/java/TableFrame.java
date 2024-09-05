import java.util.HashMap;
import java.util.Map;

public class TableFrame {
    private final Map<String, Map<Integer, Object>> rows;
    private final Map<Integer, Map<String, Object>> columns;

    public Map<Integer, Map<String, Object>> getColumns() {
        return columns;
    }


    public Map<String, Map<Integer, Object>> getRows() {
        return rows;
    }

    public TableFrame() {
        this.rows = new HashMap<>();
        this.columns = new HashMap<>();
    }

    public void addRow(String rowName) {
        rows.putIfAbsent(rowName, new HashMap<>());
    }

    protected void addColumn(int columnIndex, String rowName, Object value) {
        addRow(rowName);

        Map<Integer, Object> row = rows.get(rowName);
        row.putIfAbsent(columnIndex, value);

        Map<String, Object> columnMap = columns.computeIfAbsent(columnIndex, k -> new HashMap<>());
        columnMap.putIfAbsent(rowName, value);
    }

    public Map<Integer, Object> getRow(String rowName) {
        return rows.getOrDefault(rowName, new HashMap<>());
    }

    public Map<String, Object> getColumn(int columnIndex) {
        return columns.getOrDefault(columnIndex, new HashMap<>());
    }

    public void printTable() {
        for (Map.Entry<String, Map<Integer, Object>> rowEntry : rows.entrySet()) {
            String rowName = rowEntry.getKey();
            Map<Integer, Object> rowData = rowEntry.getValue();
            StringBuilder rowOutput = new StringBuilder(String.format("%-10s", rowName));

            for (int column : columns.keySet()) {
                Object value = rowData.getOrDefault(column, " ");
                rowOutput.append(String.format(" | %10s", value));
            }
            System.out.println(rowOutput);
        }
    }
}
