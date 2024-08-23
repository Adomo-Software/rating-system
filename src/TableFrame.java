import java.util.ArrayList;
import java.util.List;

public class TableFrame {
    final List<EmployeeEntry> data;

    public TableFrame() {
        this.data = new ArrayList<>();
    }

    public void addRow(EmployeeEntry rowData) {
        data.add(rowData);
    }

    public EmployeeEntry getColumn(int columnIndex) {
        EmployeeEntry columnData = new EmployeeEntry();
        for (List<RVpair> row : data) {
            columnData.add(row.get(columnIndex));
        }
        return columnData;
    }
}
