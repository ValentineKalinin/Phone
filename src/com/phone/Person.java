package com.phone;

import Exceptions.BodyException;

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

    public final void BODY_MASS_INDEX(double height, double weight) throws BodyException {
        if (height <= 0 || weight <= 0) {
            throw new BodyException("Problem with body characteristics");
        }
        String bmi = String.format("%.2f", weight / (height * height));
        System.out.println(personName + " BMI: " + bmi);
    }
}
