package main.java.phone;

import main.java.exceptions.BatteryCapacityException;
import main.java.exceptions.BodyCharacteristicsException;
import main.java.exceptions.ScreenDiagonalException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws BatteryCapacityException, ScreenDiagonalException, IOException {
        try {
            final String ALISON_NAME = "Alison";
            final String SCOTT_NAME = "Scott";
            final String STILES_NAME = "Stiles";

            Battery battery = new Battery(4000, "Samsung");
            Person alison = new Person(ALISON_NAME, "Hi, I'm Alison");
            Screen screen = new Screen(6.7, "OLED");
            MobilePhone samsungPhone = new MobilePhone(battery, screen, "Fold 3");
            samsungPhone.setUnlockMethod("Fingerprint");

            Battery battery2 = new Battery(3500, "Apple");
            Person scott = new Person(SCOTT_NAME, "Hi, I'm Scott");
            Screen screen2 = new Screen(6.2, "IPS");
            MobilePhone applePhone = new MobilePhone(battery2, screen2, "13 Pro Max");
            applePhone.setUnlockMethod("Face ID");
            LandlinePhone homePhone = new LandlinePhone(battery2, screen, "Samsung F535");

            Battery battery3 = new Battery(5000, "Xiaomi");
            Person stiles = new Person(STILES_NAME, "Hi, I'm Stiles");
            Screen screen3 = new Screen(5.9, "IPS");
            MobilePhone xiaomiPhone = new MobilePhone(battery3, screen3, "Mi 11 Lite");
            xiaomiPhone.setUnlockMethod("PIN code");

            Battery battery4 = new Battery(550, "Li-ion");
            Screen screen4 = new Screen(1.6, "Crystal");
            Telefax fax = new Telefax(battery4, screen4, "HP Pavilion");


            LOGGER.info("Enter username and password for computer.Macbook");
            LOGGER.info(screen2.ppiOfScreen(scott.getPersonName()));
            LOGGER.info(samsungPhone.getModel());
            LOGGER.info(applePhone.getBattery());
            LOGGER.info(screen.workTime(alison.getPersonName(), battery.getCapacity()));

            LOGGER.info("Model at Apple: " + applePhone.getModel());
            LOGGER.info(applePhone.getModel() + " unlock by " + applePhone.getUnlockMethod());
            LOGGER.info("Screen at " + samsungPhone.getModel() + ": " + samsungPhone.getScreen());

            LOGGER.info(battery.deterioration(alison.getPersonName(), battery.getCapacity()) +
                    battery.workTime(alison.getPersonName()));

            applePhone.SendMessage(alison, scott, alison.getMessage());
            fax.SendFax(scott, alison, scott.getMessage());

            samsungPhone.workable();
            fax.workable();
            homePhone.workable();

            LOGGER.info(samsungPhone.getScreen().getTechnologyOfScreen().
                    equals(xiaomiPhone.getScreen().getTechnologyOfScreen()));

            Phone.finalCurrentTime();
            LOGGER.info(LandlinePhone.operator);

            scott.BODY_MASS_INDEX(1.9, 85);
            alison.BODY_MASS_INDEX(1.65, 52);

            screen.setResolutionOfScreen(1125, 2436);
            screen.size();

            LOGGER.info("Number of phones: " + Phone.getCount());

            NewLinkedList<Phone> allPhones = new NewLinkedList<>();
            allPhones.addFirst(applePhone);
            allPhones.addFirst(samsungPhone);
            allPhones.addFirst(xiaomiPhone);
            allPhones.addLast(fax);
            allPhones.addLast(homePhone);
            LOGGER.info("All created phones: " + allPhones);
            allPhones.remove(samsungPhone);
            LOGGER.info("All created phones: " + allPhones);
            allPhones.size();

            NewLinkedList<Person> allPersons = new NewLinkedList<>();
            allPersons.addFirst(alison);
            allPersons.addLast(scott);
            allPersons.addLast(stiles);
            LOGGER.info("All created persons: " + allPersons);
            allPersons.size();

            Map<String, Person> personMap = new HashMap();
            personMap.put("1", alison);
            personMap.put("2", scott);
            personMap.put("3",stiles);
            LOGGER.info(personMap.get("2").toString());

            LinkedList<MobilePhone> order = new LinkedList<>();
            order.add(samsungPhone);
            order.add(applePhone);
            order.add(xiaomiPhone);
            MobilePhone.showOrder(order);


        } catch (BatteryCapacityException | ScreenDiagonalException | BodyCharacteristicsException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception ex) {
            LOGGER.info(ex);
        }
    }

}
/*
Lab 6.2
Move project to Maven.
Build jar file and deploy to the local repository.
Add 2 Plugins.
Run mvn for different phases from the Maven lifecycle. Check the result.

Lab 7.1
Read text from the file and calculate the numbers of the unique words.
Write the result to the file.
The main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code.

Lab 7.2
1. создать три Enums
2. создать 3 кастомных Functional Interfaces
3. https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

Lab 8
* */