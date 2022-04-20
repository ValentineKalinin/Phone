package phone;

import enums.Sex;
import exceptions.BodyCharacteristicsException;
import java.util.Objects;
import static phone.Main.LOGGER;

public class Person {
    private String personName;
    private String message;
    private Sex gender;

    public Person() {
    }

    public Person(String personName, String message, Sex gender) {
        this.message = message;
        this.personName = personName;
        this.gender = gender;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", message='" + message + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(personName, person.personName) && Objects.equals(message, person.message) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, message, gender);
    }

    public final void BODY_MASS_INDEX(double height, double weight) throws BodyCharacteristicsException {
        if (height <= 0 || weight <= 0) {
            throw new BodyCharacteristicsException("Problem with body characteristics");
        }
        String bmi = String.format("%.2f", weight / (height * height));
        LOGGER.info(personName + " BMI: " + bmi);
    }
}
