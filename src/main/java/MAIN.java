import dao.DAO_Hib;
import dao.DBException;
import unit.Unit;
import unit.Year;

public class MAIN {
    public static void main(String[] args) throws DBException {
        Year y2015 = new Year(11.11, 1.11, 324234L);
        Year y2016 = new Year(22.22, 2.22, 323466L);
        Year y2017 = new Year(33.33, 3.33, 325522L);

        Unit unit = new Unit(720212555666L, "OOO L");
        unit.addPeriod(y2015);
        unit.addPeriod(y2016);
        unit.addPeriod(y2017);


        System.out.println("Hibernate");

        DAO_Hib dao_hiB = new DAO_Hib();
        dao_hiB.insertUser(unit);
    }
}
