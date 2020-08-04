package demo.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import demo.demo.model.Person;

@Repository("fakeDao")
class FakeDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(final UUID id, final Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(final UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePerson(final UUID id) {
        final Optional<Person> person = getPersonById(id);
        if (person.isEmpty()) {
            return 0;
        }else{
            DB.remove(person.get());
            return 1;
        }
    }

    @Override
    public int updatePerson(final UUID id, final Person person) {
        final Optional<Person> p = getPersonById(id);
        if (p.isEmpty()) {
            return 0;
        }else{
            int index = DB.indexOf(p.get());
            DB.set(index, new Person(id,person.getName()));
            return 1;
        }
    }

}