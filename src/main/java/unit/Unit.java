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
    @Column(name = "iin", nullable = false, unique = true, updatable = false)
    private long iin;   // ИИН

    @Column(name = "Name", nullable = false)
    private String name;    // Наименование

    @Column(name = "okpo", nullable = false)
    private long okpo;  // ОКПО

    private String okved;   // ОКВЭД
    private int okopf;  // ОКОПФ
    private int okfs;   // ОКФС



}
