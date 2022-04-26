package interfaces.service;

import exceptions.CallOrMessageException;
import phone.Person;

public interface IFax {
    void SendFax(Person from, Person to, String fax) throws CallOrMessageException;
}
