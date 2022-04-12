package main.java.interfaces;

import main.java.phone.Person;

public interface IShortMessageService {
    void SendMessage(Person from, Person to, String mes);
}