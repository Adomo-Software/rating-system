import java.time.LocalDate;
//import java.time.Chr;
import java.util.*;

// Rate/Value Pair = RVpair
class RVpair<T extends Comparable<T>> implements Comparable<RVpair<T>> {
    public Integer rate;
    public T value;

    RVpair(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + rate + " . " + value + ")";
    }
    @Override
    public int compareTo(RVpair<T> other) {
        return this.value.compareTo(other.value);
    }
}

class DataFrame {
    final List<List<RVpair>> data;

    public DataFrame() {
        this.data = new ArrayList<>();
    }

    public void addRow(List<RVpair> rowData) {
        data.add(new ArrayList<>(rowData));
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
        for (List<RVpair> row : data) {
            System.out.println(row);
        }
        return this;
    }
}
class Data extends ArrayList<RVpair> {
    public Integer sum = 0;
    Data(String name, String birthDay, Integer income, Integer workExp, Double debtRiskRatio) {
        super();
        this.add(new RVpair<>(name));
        this.add(new RVpair<>(LocalDate.parse(birthDay)));
        this.add(new RVpair<>(income));
        this.add(new RVpair<>(workExp));
        this.add(new RVpair<>(debtRiskRatio));
    }
}

public class Main {
    public static void main(String[] args) {
        DataList dataList = new DataList();

        dataList.addRow(new Data("Emily", "1992-05-22", 15000, 8, 0.3));
        dataList.addRow(new Data("Carlos", "1978-08-11", 25000, 16, 0.65));
        dataList.addRow(new Data("Aisha", "1995-03-09", 8000, 5, 0.2));
        dataList.addRow(new Data("David", "1986-11-28", 13000, 12, 0.4));
//        dataList.addRow(new Data("Maria", "1970-06-17", 60000, 25, 0.7));
        dataList.addRow(new Data("Maria", "1970-06-17", 60000, 25, 0.7));

        dataList.rateDataList();
        System.out.println();
        /*
        [[(0 . Emily), (0 . 1992-05-22), (0 . 15000), (0 . 8), (0 . 0.3)],
         [(0 . Carlos), (0 . 1978-08-11), (0 . 25000), (0 . 16), (0 . 0.65)],
         [(0 . Aisha), (0 . 1995-03-09), (0 . 8000), (0 . 5), (0 . 0.2)],
         [(0 . David), (0 . 1986-11-28), (0 . 13000), (0 . 12), (0 . 0.4)],
         [(0 . Maria), (0 . 1970-06-17), (0 . 60000), (0 . 25), (0 . 0.7)],
         [(0 . Maria), (0 . 1970-06-17), (0 . 60000), (0 . 25), (0 . 0.7)]]
        */

//        System.out.println(dataList.getRow(5));
//        System.out.println(dataList.getRow(4));
//        System.out.println(dataList.getColumn(1));
//        System.out.println(dataList.getColumn(0));


    }
}
