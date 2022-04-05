package main;

import exceptions.BatteryCapacityException;
import exceptions.BodyCharacteristicsException;
import exceptions.ScreenDiagonalException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;

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
            MobilePhone xiaomiPhone = new MobilePhone(battery3, screen3, "Mi 11 Lite");

            LOGGER.info("Enter username and password for computer.Macbook");
            LOGGER.info(screen2.ppiOfScreen(scott.getPersonName()));
            LOGGER.info(samsungPhone.getModel());
            LOGGER.info(applePhone.getBattery());
            LOGGER.info(screen.workTime(alison.getPersonName(), battery.getCapacity()));

            LOGGER.info("Model at Apple: " + applePhone.getModel());
            applePhone.setUnlock("Face ID");
            LOGGER.info(applePhone.getModel() + " unlock by " + applePhone.getUnlock());
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
        } catch (BatteryCapacityException | ScreenDiagonalException | BodyCharacteristicsException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception ex) {
            LOGGER.info(ex);
        }
    }

}
/*
Lab 5
1. Create 5 custom exceptions.
2. Handle exceptions in 2 ways.
3. Use try-catch with resources.
4. Log messages to the console, file. (screenshots)

Lab 6
1. Read the following articles:
1.1. Generics
1.2. Collections and Maps
1.3. Thread-safe collections
2. Add 5 collections to the hierarchy.
3. Create custom LinkedList with generic.

Lab 7
Move project to Maven.
Build jar file and deploy to the local repository.
Add 2 Plugins.
Run mvn for different phases from the Maven lifecycle. Check the result.
Create custom LinkedList with generic

Lab 8
Read text from the file and calculate the numbers of the unique words.
Write the result to the file.
The main requirement is: using StringUtils and FileUtils
to implement it with minimum lines of code.

Lab 9
* */