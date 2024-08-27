import java.util.*;

public class RateValueTable extends Table {
    Map<Map.Entry<String, Map<Integer, Object>>, Integer> sums;

    public RateValueTable() {
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
