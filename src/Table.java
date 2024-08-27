import java.util.HashMap;
import java.util.Map;

public class Table extends TableFrame {
    // Same as TableFrame, but with indexes for tracking columns
    // (instead of needing to supply indexes manually)

    Map<String, Integer> indexes;

    public Table () {
        super();
        this.indexes = new HashMap<>();
    }

    @Override
    public void addRow(String rowName) {
        super.addRow(rowName);
        this.indexes.put(rowName, 0);
    }

    public void addColumn(String rowName, Object value) {
        Integer index = indexes.get(rowName);
        super.addColumn(index, rowName, value);
        indexes.put(rowName, index + 1);
    }

    public void setColumn(String rowName, Object ...values) {
        addRow(rowName);
        for (Object value : values) {
            addColumn(rowName, value);
        }
    }
}
