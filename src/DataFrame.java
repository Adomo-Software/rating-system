import java.util.ArrayList;
import java.util.List;

public class DataFrame {
    final List<Data> data;

    public DataFrame() {
        this.data = new ArrayList<>();
    }

    public void addRow(Data rowData) {
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
