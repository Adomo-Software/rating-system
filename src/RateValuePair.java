public class RateValuePair implements Comparable<RateValuePair> {
    private Integer rate = 0;
    private final Comparable<Object> value;

    public RateValuePair(Object value) {
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

    public void setRate (Integer rate) {
        this.rate = rate;
    }

    public Integer getRate() {
        return this.rate;
    }
}
