import java.util.*;


public class Main {
    public static void main(String[] args) {
        DataList dataList = new DataList();

        dataList.addRow(new Data(
                "Emily", "1992-05-22",
                15000, 8, 0.3));
        dataList.addRow(new Data(
                "Carlos", "1978-08-11",
                25000, 16, 0.65));
        dataList.addRow(new Data(
                "Aisha", "1995-03-09",
                8000, 5, 0.2));
        dataList.addRow(new Data(
                "David", "1986-11-28",
                13000, 12, 0.4));
        dataList.addRow(new Data(
                "Maria", "1970-06-17",
                60000, 25, 0.7));

        dataList.rateDataList().getRated();
    }
}
