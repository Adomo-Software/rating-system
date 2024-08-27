public class Main {
    public static void main(String[] args) {
        Table t = new Table();

        t.addRow("name");
        t.addColumn("name", new RateValuePair("jeff"));
        t.addColumn("name", new RateValuePair("adam"));

        t.addRow("age");
        t.addColumn("age", new RateValuePair(21));
        t.addColumn("age", new RateValuePair(22));

        t.printTable();
    }
}
