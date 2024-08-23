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

    public DataEntry getColumn(int columnIndex) {
        DataEntry columnData = new DataEntry();
        for (List<RVpair> row : data) {
            columnData.add(row.get(columnIndex));
        }
        return columnData;
    }
}
