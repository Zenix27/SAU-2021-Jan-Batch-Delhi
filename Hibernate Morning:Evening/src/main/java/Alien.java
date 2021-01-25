import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    private String aName;
    private String color;
    public Alien() {}
    public Alien(String aName, String color) {
        this.aName = aName;
        this.color = color;
    }
    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
