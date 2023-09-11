package cz.bartosek.prace_s_person;

import java.util.List;

public interface PersonRepository {

    public void createPerson(String name, String sex, String birthday);

    public void deletePerson(Long personId);

    public List<Person> getPersonForName(String name);

    public List<Person> getAllPersons();

    public void updatePerson(long personId, String name);

    public Person getPersonById(Long id);
}
