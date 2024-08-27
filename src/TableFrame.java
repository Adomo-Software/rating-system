import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class TableFrame {
    Map<String, Map<Integer, Object>> rows;
    Map<Integer, Map<String, Object>> columns;


    public TableFrame() {
        this.rows = new HashMap<>();
        this.columns = new HashMap<>();
    }

    public void addRow(String rowName) {
        if (!rows.containsKey(rowName)) {
            rows.put(rowName, new HashMap<>());
        }
    }

    protected void addColumn(int columnIndex, String rowName, Object value) {
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

class Table extends TableFrame {
    // Same as TableFrame, but with indexes for tracking columns
    // (instead of needing to supply indexes manually)

    Map<String, Integer> indexes;

    public Table () {
        super();
        this.indexes = new HashMap<>();
    }

    @Override
    public void addRow(String rowName) {
        super.addRow(rowName);
        this.indexes.put(rowName, 0);
    }

    public void addColumn(String rowName, Object value) {
        Integer index = indexes.get(rowName);
        super.addColumn(index, rowName, value);
        indexes.put(rowName, index + 1);
    }

    public void setColumn(String rowName, Object ...values) {
        addRow(rowName);
        for (Object value : values) {
            addColumn(rowName, value);
        }
    }
}

class RateValueTable extends Table {
    Map<Map.Entry<String, Map<Integer, Object>>, Integer> sums;

    public RateValueTable () {
        super();
        sums = new HashMap<>();
    }
    public void addColumn(String rowName, Object value) {
        super.addColumn(rowName, new RateValuePair(value));
    }

    public void rateColumn(Integer column) {
        List<RateValuePair> list = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Object>> rowEntry : super.rows.entrySet()) {
            RateValuePair rvp = (RateValuePair) rowEntry.getValue().get(column);
            list.add(rvp);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).rate = i + 1;
        }
    }

    public void rate() {
        for (int i = 0; i < columns.size(); i++) {
            rateColumn(i);
        }
        for (Map.Entry<String, Map<Integer, Object>> rowEntry : super.rows.entrySet()) {
            Integer acc = 0;
            for (Map.Entry<Integer, Object> o : rowEntry.getValue().entrySet()) {
                RateValuePair rvp = (RateValuePair) o.getValue();
                acc += rvp.rate;
            }
            sums.put(rowEntry, acc);
        }
    }

    @Override
    public void printTable() {
        for (Map.Entry<String, Map<Integer, Object>> rowEntry : rows.entrySet()) {
            String rowName = rowEntry.getKey();
            Map<Integer, Object> rowData = rowEntry.getValue();
            StringBuilder rowOutput = new StringBuilder(String.format("%-10s", rowName));

            for (int col : columns.keySet()) {
                Object value = rowData.getOrDefault(col, " ");
                rowOutput.append(String.format(" | %10s", value));
            }
            rowOutput.append(String.format(" | Total: %10s", sums.get(rowEntry)));


            System.out.println(rowOutput);
        }
    }
}