public class Main {
    public static void main(String[] args) {
        RateValueTable t = new RateValueTable();

        t.setColumn("Emily", "1992-05-22", 15000, 8, 0.3);
        t.setColumn("Carlos", "1978-08-11", 25000, 16, 0.65);
        t.setColumn("Aisha", "1995-03-09", 8000, 5, 0.2);
        t.setColumn("David", "1986-11-28", 13000, 12, 0.4);
        t.setColumn("Maria", "1970-06-17", 60000, 25, 0.7);

        t.rate();
        t.printTable();

    }
}
