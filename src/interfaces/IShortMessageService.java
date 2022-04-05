package interfaces;

import main.Person;

public interface IShortMessageService {
    void SendMessage(Person from, Person to, String mes);
}