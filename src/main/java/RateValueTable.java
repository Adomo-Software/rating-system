import java.util.*;

public class RateValueTable extends Table {
    private HashMap<Map.Entry<String, Map<Integer, Object>>, Integer> sums;

    public RateValueTable() {
        super();
        sums = new HashMap<>();
    }

    public static HashMap<Map.Entry<String, Map<Integer, Object>>, Integer>
    sortByValue(  HashMap<Map.Entry<String, Map<Integer, Object>>, Integer> hm) {
        List<Map.Entry<Map.Entry<String, Map<Integer, Object>>, Integer>> list =
                new LinkedList<>(hm.entrySet());

        list.sort(
                Map.Entry.<Map.Entry<String, Map<Integer, Object>>, Integer>
                comparingByValue().reversed());

        HashMap<Map.Entry<String, Map<Integer, Object>>, Integer>
                temp = new LinkedHashMap<>();
        for (Map.Entry<Map.Entry<String, Map<Integer, Object>>, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    public void addColumn(String rowName, Object value) {
        super.addColumn(rowName, new RateValuePair(value));
    }

    private void rateColumn(Integer column) {
        List<RateValuePair> list = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Object>> rowEntry : super.getRows().entrySet()) {
            RateValuePair rateValuePair = (RateValuePair) rowEntry.getValue().get(column);
            list.add(rateValuePair);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setRate(i + 1);
        }
    }

    public void rate() {
        for (int i = 0; i < super.getColumns().size(); i++) {
            rateColumn(i);
        }
        for (Map.Entry<String, Map<Integer, Object>> rowEntry : super.getRows().entrySet()) {
            Integer accumulator = 0;
            for (Map.Entry<Integer, Object> object : rowEntry.getValue().entrySet()) {
                RateValuePair rateValuePair = (RateValuePair) object.getValue();
                accumulator += rateValuePair.getRate();
            }
            sums.put(rowEntry, accumulator);
        }
        sums = sortByValue(sums);
    }

    @Override
    public void printTable() {
        for (Map.Entry<Map.Entry<String, Map<Integer, Object>>, Integer> sum : sums.entrySet()) {
            String rowName = sum.getKey().getKey();
            Map<Integer, Object> rowData = sum.getKey().getValue();
            StringBuilder rowOutput = new StringBuilder(String.format("%-10s", rowName));
            for (Object column : rowData.values()) {
                rowOutput.append(String.format(" | %10s", column));
            }
            rowOutput.append(String.format(" | Total: %10s", sum.getValue()));

            System.out.println(rowOutput);
        }
    }
}

