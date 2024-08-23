import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTable extends TableFrame {
    private DataEntry sortColumn(DataEntry column) {
        Collections.sort(column);
        return column;
    }

    private DataEntry sortColumnReverse(DataEntry column) {
        Collections.sort(column, Collections.reverseOrder());
        return column;
    }

    private void rateColumn(int columnIndex) {
        DataEntry originalColumn = getColumn(columnIndex);
        DataEntry sorted = sortColumn(originalColumn);
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).rate = i + 1;
        }
    }

    private void rateColumnReverse(int columnIndex) {
        DataEntry originalColumn = getColumn(columnIndex);
        DataEntry sorted = (DataEntry) sortColumnReverse(originalColumn);
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
