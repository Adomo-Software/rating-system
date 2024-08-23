import java.time.LocalDate;
import java.util.ArrayList;

public class DataEntry extends ArrayList<RVpair> implements Comparable<DataEntry> {
    public Integer sum = 0;
    DataEntry(String name, String birthDay, Integer income,
              Integer workExp, Double debtRiskRatio) {
        super();
        this.add(new RVpair(name));
        this.add(new RVpair(LocalDate.parse(birthDay)));
        this.add(new RVpair(income));
        this.add(new RVpair(workExp));
        this.add(new RVpair(debtRiskRatio));
    }

    @Override
    public int compareTo(DataEntry data) {
        return this.sum.compareTo(data.sum);
    }
}
