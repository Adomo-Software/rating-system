// Rate/Value Pair = RVpair
public class RVpair implements Comparable<RVpair> {
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
