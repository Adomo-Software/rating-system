import java.util.Collections;

public class EmployeeList extends TableFrame {
    private EmployeeEntry sortColumn(EmployeeEntry column) {
        Collections.sort(column);
        return column;
    }

    private EmployeeEntry sortColumnReverse(EmployeeEntry column) {
        Collections.sort(column, Collections.reverseOrder());
        return column;
    }

    private void rateColumn(int columnIndex) {
        EmployeeEntry originalColumn = getColumn(columnIndex);
        EmployeeEntry sorted = sortColumn(originalColumn);
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).rate = i + 1;
        }
    }

    private void rateColumnReverse(int columnIndex) {
        EmployeeEntry originalColumn = getColumn(columnIndex);
        EmployeeEntry sorted = (EmployeeEntry) sortColumnReverse(originalColumn);
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).rate = i + 1;
        }
    }
    public EmployeeList rateDataList() {
        rateColumnReverse(0);
        rateColumn(1);
        rateColumn(2);
        rateColumn(3);
        rateColumnReverse(4);
        for (EmployeeEntry row : data) {
            for (RVpair pair: row) {
                row.sum += pair.rate;
            }
        }

        Collections.sort(data, Collections.reverseOrder());
        return this;
    }
    public void getRated() {
        for (EmployeeEntry row : data) {
            System.out.println(row + " Total rating: " + row.sum);
        }
    }
}
