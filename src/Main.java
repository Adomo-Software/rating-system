public class Main {
    public static void main(String[] args) {
        Table t = new Table();

        t.addRow("name");
        t.addColumn("name", new RVpair("jeff"));
        t.addColumn("name", new RVpair("adam"));

        t.addRow("age");
        t.addColumn("age", new RVpair(21));
        t.addColumn("age", new RVpair(22));

        t.printTable();
    }
}
