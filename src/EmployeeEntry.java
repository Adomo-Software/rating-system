import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeEntry extends ArrayList<RVpair> implements Comparable<EmployeeEntry> {
    public Integer sum = 0;
    EmployeeEntry(String name, String birthDay, Integer income,
                  Integer workExp, Double debtRiskRatio) {
        super();
        this.add(new RVpair(name));
        this.add(new RVpair(LocalDate.parse(birthDay)));
        this.add(new RVpair(income));
        this.add(new RVpair(workExp));
        this.add(new RVpair(debtRiskRatio));
    }
    EmployeeEntry() {
        super();
    }

    @Override
    public int compareTo(EmployeeEntry data) {
        return this.sum.compareTo(data.sum);
    }
}
