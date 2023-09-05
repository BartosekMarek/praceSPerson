package cz.bartosek.prace_s_person;

import jakarta.transaction.Transactional;//fakt jakarta? nemelo by z javax

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createPerson(Person person){
        entityManager.persist(person);
    }
    @Transactional
    public void updatePerson(Person person){
        entityManager.merge(person);
    }

    public Person getPersonById(Long id){
        return entityManager.find(Person.class, id);
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

    public List<Person> getPersonForName(String name){
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.name = :tempName", Person.class);
        query.setParameter("tempName", name);
        return query.getResultList();
    }




}
