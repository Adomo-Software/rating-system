import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataList extends DataFrame {
    public List<RVpair> sortColumn(List<RVpair> column) {
        List<RVpair> sortedColumn = new ArrayList<>(column);
        Collections.sort(sortedColumn);
        return sortedColumn;
    }

    public List<RVpair> sortColumnReverse(List<RVpair> column) {
        List<RVpair> sortedColumn = new ArrayList<>(column);
        Collections.sort(sortedColumn, Collections.reverseOrder());
        return sortedColumn;
    }

    public void rateColumn(int columnIndex) {
        List<RVpair> originalColumn = getColumn(columnIndex);
        List<RVpair> sorted = sortColumn(originalColumn);
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).rate = i + 1;
        }
    }

    public void rateColumnReverse(int columnIndex) {
        List<RVpair> originalColumn = getColumn(columnIndex);
        List<RVpair> sorted = sortColumnReverse(originalColumn);
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).rate = i + 1;
        }
    }
    public DataList rateDataList() {
        rateColumnReverse(0);
        rateColumn(1);
        rateColumn(2);
        rateColumn(3);
        rateColumnReverse(4);
        for (Data row : data) {
            for (RVpair pair: row) {
                row.sum += pair.rate;
            }
        }

        Collections.sort(data, Collections.reverseOrder());
        return this;
    }
    public void getRated() {
        for (Data row : data) {
            System.out.println("total rating: " +row.sum + " | data: " + row);
        }
    }
}
