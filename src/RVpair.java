// Rate/Value Pair = RVpair
public class RVpair implements Comparable<RVpair> {
    public Integer rate = 0;
    private Comparable<Object> value;

    RVpair(Object value) {
        this.value = (Comparable<Object>) value;
    }

    @Override
    public String toString() {
        return this.value + "(" + this.rate + ")";
    }

    @Override
    public int compareTo(RVpair rVpair) {
        return this.value.compareTo(rVpair.value);
    }
}
