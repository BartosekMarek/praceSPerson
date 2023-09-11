package cz.bartosek.prace_s_person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Getter
@Setter

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private SexEnum sex;

    @Column(name = "birthday")
    private Date birthday;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Person(String name, String sex, String birthday) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name=name;
        try {
            this.sex = SexEnum.valueOf(sex);
        } catch (IllegalArgumentException e) {
            System.out.println("Neplatná hodnota pro enumSex - může být jen ve tvaru: MAN nebo WOMAN");
        }
        try {
            this.birthday = dateFormat.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Chyba při parsování datumu: " + e.getMessage());
        }
    }

    public Person() {
        Random random = new Random();
        this.id = random.nextLong();
    }
}
