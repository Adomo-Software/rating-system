import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class TableFrame {
    Map<String, Map<Integer, Object>> rows;
    Map<Integer, Map<String, Object>> columns;
    Integer rowIndex;
    Integer colIndex;

    public TableFrame() {
        this.rows = new HashMap<>();
        this.columns = new HashMap<>();
        rowIndex = 0;
        colIndex = 0;
    }

    public void addRow(String rowName) {
        if (!rows.containsKey(rowName)) {
            rows.put(rowName, new HashMap<>());
        }
    }

    public void addColumn(int columnIndex, String rowName, Object value) {
        addRow(rowName);

        Map<Integer, Object> row = rows.get(rowName);
        row.put(columnIndex, value);

        Map<String, Object> columnMap = columns.computeIfAbsent(columnIndex, k -> new HashMap<>());
        columnMap.put(rowName, value);
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

            for (int col : columns.keySet()) {
                Object value = rowData.getOrDefault(col, " ");
                rowOutput.append(String.format(" | %10s", value));
            }

            System.out.println(rowOutput);
        }
    }
}
