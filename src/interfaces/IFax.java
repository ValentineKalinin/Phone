package interfaces;

import main.Person;

public interface IFax {
    void SendFax(Person from, Person to, String fax);
}
