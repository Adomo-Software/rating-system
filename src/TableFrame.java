import java.util.ArrayList;
import java.util.List;

public class TableFrame {
    final List<DataEntry> data;

    public TableFrame() {
        this.data = new ArrayList<>();
    }

    public void addRow(DataEntry rowData) {
        data.add(rowData);
    }

    public List<RVpair> getColumn(int columnIndex) {
        List<RVpair> columnData = new ArrayList<>();
        for (List<RVpair> row : data) {
            columnData.add(row.get(columnIndex));
        }
        return columnData;
    }
}
