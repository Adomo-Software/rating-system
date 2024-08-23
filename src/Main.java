import java.time.LocalDate;
//import java.time.Chr;
import java.util.*;

// Rate/Value Pair = RVpair
class RVpair implements Comparable<RVpair> {
    public Integer rate = 0;
    public Comparable<Object> value;

    RVpair(Object value) {
        this.value = (Comparable<Object>) value;
    }

    @Override
    public String toString() {
        return "(R: " + this.rate + " | V: " + this.value + ")";
    }
    @Override
    public int compareTo(RVpair rVpair) {
        return this.value.compareTo(rVpair.value);
    }
}


class DataFrame {
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

    public List<RVpair> getRow(int rowIndex) {
        return new ArrayList<>(data.get(rowIndex));
    }
}

class DataList extends DataFrame {
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
class Data extends ArrayList<RVpair> implements Comparable<Data> {
    public Integer sum = 0;
    Data(String name, String birthDay, Integer income, Integer workExp, Double debtRiskRatio) {
        super();
        this.add(new RVpair(name));
        this.add(new RVpair(LocalDate.parse(birthDay)));
        this.add(new RVpair(income));
        this.add(new RVpair(workExp));
        this.add(new RVpair(debtRiskRatio));
    }

    @Override
    public int compareTo(Data data) {
        return this.sum.compareTo(data.sum);
    }
}

public class Main {
    public static void main(String[] args) {
        DataList dataList = new DataList();

        dataList.addRow(new Data("Emily", "1992-05-22", 15000, 8, 0.3));
        dataList.addRow(new Data("Carlos", "1978-08-11", 25000, 16, 0.65));
        dataList.addRow(new Data("Aisha", "1995-03-09", 8000, 5, 0.2));
        dataList.addRow(new Data("David", "1986-11-28", 13000, 12, 0.4));
        dataList.addRow(new Data("Maria", "1970-06-17", 60000, 25, 0.7));

        dataList.rateDataList().getRated();
    }
}
