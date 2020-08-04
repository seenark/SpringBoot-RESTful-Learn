package demo.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.demo.dao.PersonDao;
import demo.demo.model.Person;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") final PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(final Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return this.personDao.selectAllPeople();
    }

    public Person getPersonById(final UUID id) {
        return this.personDao.getPersonById(id).orElse(null);
    }

    public int deletePersonById(final UUID id) {
        return this.personDao.deletePerson(id);
    }
    public int updatePersonById(final UUID id, final Person person) {
        return this.personDao.updatePerson(id, person);
    }
}