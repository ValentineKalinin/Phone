package com.phone;

public class Main {
    public static void main(String[] args) {
        Battery battery = new Battery(4000, "Samsung");
        Person alison = new Person("Alison", "Hi, I'm Alison");
        Screen screen = new Screen(6.7, "OLED");

        Battery battery2 = new Battery(3500, "Apple");
        Person scott = new Person("Scott", "Hi, I'm Scott");
        Screen screen2 = new Screen(6.2, "IPS");

        MobilePhone samsungPhone = new MobilePhone(battery, screen, "Fold 3");
        MobilePhone applePhone = new MobilePhone(battery2, screen2, "13 Pro Max");
        Telefax fax = new Telefax(battery, screen, "HP Pavilion");
        LandlinePhone homePhone = new LandlinePhone(battery2, screen, "Samsung F535");

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
    }
}

/*
Lab 3
2.investigate gitignore and add it in your projects

Lab 4
- Add 5 interfaces to the existing hierarchy.
- Use polymorphism with the abstract class and interface from the hierarchy.
- Create final class, method, variable.
- Create a static block, method, variable.
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