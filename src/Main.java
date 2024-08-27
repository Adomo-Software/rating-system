public class Main {
    public static void main(String[] args) {
        TableFrame t = new TableFrame();

        t.addRow("name");
        t.addColumn(0, "name", new RVpair("jeff"));
        t.addColumn(1, "name", new RVpair("adam"));

        t.addRow("age");
        t.addColumn(0, "age", new RVpair(21));
        t.addColumn(1, "age", new RVpair(22));

        t.printTable();
    }
}
