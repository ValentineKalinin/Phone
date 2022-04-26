package interfaces.functional;

import enums.Sex;
import phone.Person;

@FunctionalInterface
public interface IPersonCreate<P extends Person> {
    P create(String personName, String personSurname, String message, Sex gender);
}
