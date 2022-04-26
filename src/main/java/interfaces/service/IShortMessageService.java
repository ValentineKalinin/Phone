package interfaces.service;

import exceptions.MessageException;
import phone.Person;

public interface IShortMessageService {
    void SendMessage(Person from, Person to, String mes) throws MessageException;
}