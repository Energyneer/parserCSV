package unit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organisations")
public class Unit implements Serializable {
    private int count = 0;

    @Id
    @Column(name = "IIN", unique = true, updatable = false, nullable = false)
    private long IIN;

    @Column(name = "Name")
    private String name;

    @Column(name = "ListOfYears")
//    private List<Year> list;
    private Year[] list;



    public Unit() {
    }

    public Unit(long IIN, String name) {
        this.IIN = IIN;
        this.name = name;
        this.list = new Year[10];
    }

    public void addPeriod(Year year) {
        this.list[count] = year;
        count++;
    }

    public long getIIN() {
        return IIN;
    }

    public String getName() {
        return name;
    }

    public Year[] getList() {
        return list;
    }
}
