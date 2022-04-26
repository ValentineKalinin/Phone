package interfaces.service;

import exceptions.CallOrMessageException;
import phone.Person;

public interface IShortMessageService {
    void SendMessage(Person from, Person to, String mes) throws CallOrMessageException;
}