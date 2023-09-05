package cz.bartosek.prace_s_person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "person")
public class Person {
    @Id
    private Long id;
    private String name;
    private SexEnum sex;
    private Date birthday;

}
