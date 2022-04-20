package interfaces;

import phone.Person;

public interface IShortMessageService {
    void SendMessage(Person from, Person to, String mes);
}