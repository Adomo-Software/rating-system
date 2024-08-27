public class Main {
    public static void main(String[] args) {
        RateValueTable t = new RateValueTable();

        t.setColumn("name", "jeff", "adam");
        t.setColumn("age", 21, 22);

        t.printTable();
    }
}
