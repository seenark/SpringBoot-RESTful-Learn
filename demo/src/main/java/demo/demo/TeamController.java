package demo.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private List<PersonModel> teams = new ArrayList<PersonModel>();

    public TeamController() {
        teams.add(new PersonModel(1, "John", "Doe"));
        teams.add(new PersonModel(2, "Prayud", "Jaano"));
        teams.add(new PersonModel(3, "Praveet", "Whang"));
        teams.add(new PersonModel(4, "Sean", "Boo"));
    }

    @GetMapping("/team")
    public List<PersonModel> myTeam() {
        return teams;
    }

    @GetMapping("/teamById")
    public PersonModel getTeamFromId(@RequestParam(defaultValue = "1", name = "id") String personId) {
        PersonModel result = new PersonModel();
        boolean found = false;

        for (PersonModel e : teams) {

            if (e.getId() == Integer.parseInt(personId)) {
                found = true;
                result = e;
                break;

            }
        }
        if (found) {
            return result;
        } else {
            throw new TeamException(personId);
        }

    }

    @GetMapping("/team/{id}")
    public PersonModel getTeamById2(@PathVariable(name = "id") String personId) {
        PersonModel result = new PersonModel();
        boolean found = false;

        for (PersonModel e : teams) {

            if (e.getId() == Integer.parseInt(personId)) {
                found = true;
                result = e;
                break;

            }
        }
        if (found) {
            return result;
        } else {
            throw new TeamException(personId);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/team")
    public void setTeamMember(@RequestBody List<PersonModel> p) {
        for (PersonModel e : p) {
            PersonModel newP = new PersonModel(e.getId(), e.getFirstName(), e.getLastName());
            teams.add(newP);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/team/{id}")
    public void updateTeamMember(@RequestBody PersonModel person, @PathVariable(name = "id") String personId) {
        boolean found = false;
        PersonModel p = null;
        for (PersonModel e : teams) {
            if (e.getId() == Integer.parseInt(personId)) {
                p = e;
                found = true;
                break;
            }
        }
        if (found) {
            p.setFirstName(person.getFirstName());
            p.setLastName(person.getLastName());
        } else {
            throw new TeamException(personId);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/team/{id}")
    public void deleteTeamMember(@PathVariable(name = "id") String personId) {
        boolean found = false;
        PersonModel p = null;
        for (PersonModel e : teams) {
            if (e.getId() == Integer.parseInt(personId)) {
                p = e;
                found = true;
                break;
            }
        }
        if (found) {
            teams.remove(p);
        } else {
            throw new TeamException(personId);
        }
    }
}
