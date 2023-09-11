package cz.bartosek.prace_s_person;

import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;//fakt jakarta? nemelo by z javax?

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PersonService implements PersonRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createPerson(Person person){
        entityManager.persist(person);
    }

    public Person getPersonById(Long id){
        return entityManager.find(Person.class, id);
    }

    @Override
    @Transactional
    public void createPerson(String name, String sex, String birthday) {
        Person personTemp = new Person(name,sex,birthday);
        createPerson(personTemp);
    }

    @Transactional
    public void deletePerson(Long id){
        Person personTemp = this.getPersonById(id);

        if(personTemp != null) {
            entityManager.remove(personTemp);
        }
    }

    public List<Person> getAllPersons(){
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    @Transactional
    public void updatePerson(long personId, String name) {
        Person personTemp = this.getPersonById(personId);
        if(personTemp != null){
            personTemp.setName(name);
            entityManager.merge(personTemp);
        }
    }

    public List<Person> getPersonForName(String name){
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.name = :tempName", Person.class);
        query.setParameter("tempName", name);
        return query.getResultList();
    }

}
