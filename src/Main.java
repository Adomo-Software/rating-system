public class Main {
    public static void main(String[] args) {
        RateValueTable t = new RateValueTable();

        t.addRow("name");
        t.addColumn("name", "jeff");
        t.addColumn("name", "adam");

        t.addRow("age");
        t.addColumn("age", 21);
        t.addColumn("age", 22);

        t.printTable();
    }
}
