import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTable extends TableFrame {
    private List<RVpair> sortColumn(List<RVpair> column) {
        List<RVpair> sortedColumn = new ArrayList<>(column);
        Collections.sort(sortedColumn);
        return sortedColumn;
    }

    private List<RVpair> sortColumnReverse(List<RVpair> column) {
        List<RVpair> sortedColumn = new ArrayList<>(column);
        Collections.sort(sortedColumn, Collections.reverseOrder());
        return sortedColumn;
    }

    private void rateColumn(int columnIndex) {
        List<RVpair> originalColumn = getColumn(columnIndex);
        List<RVpair> sorted = sortColumn(originalColumn);
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).rate = i + 1;
        }
    }

    private void rateColumnReverse(int columnIndex) {
        List<RVpair> originalColumn = getColumn(columnIndex);
        List<RVpair> sorted = sortColumnReverse(originalColumn);
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).rate = i + 1;
        }
    }
    public DataTable rateDataList() {
        rateColumnReverse(0);
        rateColumn(1);
        rateColumn(2);
        rateColumn(3);
        rateColumnReverse(4);
        for (DataEntry row : data) {
            for (RVpair pair: row) {
                row.sum += pair.rate;
            }
        }

        Collections.sort(data, Collections.reverseOrder());
        return this;
    }
    public void getRated() {
        for (DataEntry row : data) {
            System.out.println(row + " Total rating: " + row.sum);
        }
    }
}
