package demo.demo;

import java.util.Objects;

public class PersonModel {
    private int id;
    private String firstName;
    private String lastName;

    public PersonModel() {
    }

    public PersonModel(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonModel id(int id) {
        this.id = id;
        return this;
    }

    public PersonModel firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonModel lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonModel)) {
            return false;
        }
        PersonModel personModel = (PersonModel) o;
        return id == personModel.id && Objects.equals(firstName, personModel.firstName) && Objects.equals(lastName, personModel.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }
    

}