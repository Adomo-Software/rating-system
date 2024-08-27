public class RateValuePair implements Comparable<RateValuePair> {
    public Integer rate = 0;
    private Comparable<Object> value;

    RateValuePair(Object value) {
        this.value = (Comparable<Object>) value;
    }

    @Override
    public String toString() {
        return this.value + "(" + this.rate + ")";
    }

    @Override
    public int compareTo(RateValuePair rVpair) {
        return this.value.compareTo(rVpair.value);
    }
}
