package demo.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import demo.demo.model.Person;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(final Person person) {
        final UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    
    List<Person> selectAllPeople();
    Optional<Person> getPersonById(UUID id);
    int deletePerson(UUID id);
    int updatePerson(UUID id, Person person);
}