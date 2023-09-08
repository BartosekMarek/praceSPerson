package cz.bartosek.prace_s_person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private SexEnum sex;
    private Date birthday;

    public Person(String name, String sex, String birthday) {
//        this.id = random.UUID;
        this.name=name;
//        sex
//        birthday
    }

    public Person() {

    }
}
