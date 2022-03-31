package com.phone;

public class Person {
    private String personName;
    private String message;

    public Person() {
    }

    public Person(String personName, String message) {
        this.message = message;
        this.personName = personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Person {" +
                "personName = " + personName +
                ", message = '" + message + '\'' +
                '}';
    }
}
