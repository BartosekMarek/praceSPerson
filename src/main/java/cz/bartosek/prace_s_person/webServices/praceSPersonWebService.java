package cz.bartosek.prace_s_person.webServices;

import cz.bartosek.prace_s_person.Person;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;

@WebService
public class praceSPersonWebService {
    @EJB
    private Person person;
}
