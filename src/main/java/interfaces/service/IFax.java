package interfaces.service;

import exceptions.MessageException;
import phone.Person;

public interface IFax {
    void SendFax(Person from, Person to, String fax) throws MessageException;
}
