package com.phone;

public class Main {
    public static void main(String[] args) {
        final String ALISON_NAME = "Alison";
        final String SCOTT_NAME = "Scott";
        final String STILES_NAME = "Stiles";

        Battery battery = new Battery(4000, "Samsung");
        Person alison = new Person(ALISON_NAME, "Hi, I'm Alison");
        Screen screen = new Screen(6.7, "OLED");

        Battery battery2 = new Battery(3500, "Apple");
        Person scott = new Person(SCOTT_NAME, "Hi, I'm Scott");
        Screen screen2 = new Screen(6.2, "IPS");

        Battery battery3 = new Battery(5000, "Xiaomi");
        Person stiles = new Person(STILES_NAME, "Hi, I'm Stiles");
        Screen screen3 = new Screen(5.9, "IPS");

        MobilePhone samsungPhone = new MobilePhone(battery, screen, "Fold 3");
        MobilePhone applePhone = new MobilePhone(battery2, screen2, "13 Pro Max");
        Telefax fax = new Telefax(battery, screen, "HP Pavilion");
        LandlinePhone homePhone = new LandlinePhone(battery2, screen, "Samsung F535");
        MobilePhone xiaomiPhone = new MobilePhone(battery3,screen3,"Mi 11 Lite");

        System.out.println(screen2.ppiOfScreen(scott.getPersonName()));
        System.out.println(samsungPhone.getModel());
        System.out.println(applePhone.getBattery());
        System.out.println(screen.workTime(alison.getPersonName(), battery.getCapacity()));

        System.out.println("\nModel at Apple: " + applePhone.getModel());
        applePhone.setUnlock("Face ID");
        System.out.println(applePhone.getModel() + " unlock by " + applePhone.getUnlock());
        System.out.println("Screen at " + samsungPhone.getModel() + ": " + samsungPhone.getScreen());

        System.out.println(battery.deterioration(alison.getPersonName(), battery.getCapacity()) +
                battery.workTime(alison.getPersonName()));

        applePhone.SendMessage(alison,scott,alison.getMessage());
        fax.SendFax(scott, alison, scott.getMessage());

        samsungPhone.workable();
        fax.workable();
        homePhone.workable();

        System.out.println(samsungPhone.getScreen().getTechnologyOfScreen().equals(xiaomiPhone.getScreen().getTechnologyOfScreen()));

        Phone.finalCurrentTime();
        System.out.println(LandlinePhone.operator);

        scott.BODY_MASS_INDEX(1.9,85);
        alison.BODY_MASS_INDEX(1.65, 52);

        System.out.println("Number of phones: " + Phone.getCount());
    }
}

/*
Lab 4
- Update gitignore file. The Github repository should not have an .idea and out folders.

Lab 5
Create 5 custom exceptions.
Handle exceptions in 2 ways.
Use try-catch with resources.
Log messages to the console, file. (screenshots)

Lab 6
Read the following articles:
Generics
Collections and Maps
Thread-safe collections
Add 5 collections to the hierarchy.
Create custom LinkedList with generic.
* */