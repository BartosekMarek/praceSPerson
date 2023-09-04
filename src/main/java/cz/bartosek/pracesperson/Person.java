package cz.bartosek.pracesperson;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "person")
public class Person {
    @Id
    private Long id;
    private String name;
    private Enum sex;
    private Date birthday;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}
