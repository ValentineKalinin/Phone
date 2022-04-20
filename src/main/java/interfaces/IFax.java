package interfaces;

import phone.Person;

public interface IFax {
    void SendFax(Person from, Person to, String fax);
}
