package main.java.phone;

import main.java.enums.PhoneBrands;
import main.java.enums.Sex;
import main.java.exceptions.BatteryCapacityException;
import main.java.exceptions.BodyCharacteristicsException;
import main.java.exceptions.ScreenDiagonalException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws BatteryCapacityException, ScreenDiagonalException, IOException {
        try {
            final String ALISON_NAME = "Alison";
            final String SCOTT_NAME = "Scott";
            final String STILES_NAME = "Stiles";

            Battery battery = new Battery(4000, "Samsung");
            Person alison = new Person(ALISON_NAME, "Hi, I'm Alison", Sex.WOMAN);
            Screen screen = new Screen(6.7, "OLED");
            MobilePhone samsungPhone = new MobilePhone(battery, screen, "Fold 3");
            samsungPhone.setUnlockMethod("Fingerprint");

            Battery battery2 = new Battery(3500, "Apple");
            Person scott = new Person(SCOTT_NAME, "Hi, I'm Scott", Sex.MAN);
            Screen screen2 = new Screen(6.2, "IPS");
            MobilePhone applePhone = new MobilePhone(battery2, screen2, "13 Pro Max");
            applePhone.setUnlockMethod("Face ID");
            LandlinePhone homePhone = new LandlinePhone(battery2, screen, "Samsung F535");

            Battery battery3 = new Battery(5000, "Xiaomi");
            Person stiles = new Person(STILES_NAME, "Hi, I'm Stiles", Sex.MAN);
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
            personMap.put("3", stiles);
            LOGGER.info(personMap.get("2").toString());

            LinkedList<MobilePhone> order = new LinkedList<>();
            order.add(samsungPhone);
            order.add(applePhone);
            order.add(xiaomiPhone);
            MobilePhone.showOrder(order);


            String s = StringUtils.lowerCase(FileUtils.readFileToString(
                            new File("src/main/resources/text.txt"), String.valueOf(StandardCharsets.UTF_8)))
                    .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
            String[] arr = s.split(" ");
            Set<String> set = new HashSet(List.of(arr));
            List<String> lst = set.stream()
                    .map(x -> x + " " + StringUtils.countMatches(s, x))
                    .collect(Collectors.toList());
            FileUtils.writeLines(new File("src/main/resources/count.txt"), lst);
            LOGGER.info("The file 'count.txt' with the numbers of the unique words was created");

            ArrayList<PhoneBrands> stilesPhoneTaste = new ArrayList<>();
            stilesPhoneTaste.add(PhoneBrands.APPLE);
            stilesPhoneTaste.add(PhoneBrands.SAMSUNG);
            Shopper stilesShopper = new Shopper(stilesPhoneTaste);
            stilesShopper.recommendPhoneBrand(stilesShopper);
            stilesShopper.printBookTaste(stilesPhoneTaste);
            stilesShopper.recommendActivity();
        } catch (BatteryCapacityException | ScreenDiagonalException | BodyCharacteristicsException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception ex) {
            LOGGER.info(ex);
        }
    }

}
/*
Lab 7.2
1. создать три Enums
2. создать 3 кастомных Functional Interfaces
3. https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html


Intermediate Operations :
map(), filter(), distinct(), sorted(), limit(), skip()
Terminal Operations :
forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()

Lab 8
+ кастомный LinedList
+ .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "")
+ The settings element in the settings.xml file contains elements used to define values which configure Maven execution in various ways, like the pom.xml, but should not be bundled to any specific project, or distributed to an audience. These include values such as the local repository location, alternate remote repository servers, and authentication information.

There are two locations where a settings.xml file may live:
The Maven install: ${maven.home}/conf/settings.xml
A user's install: ${user.home}/.m2/settings.xml

git reset HEAD
Create 2 Threads using Runnable and Thread.
Create Connection Pool. Use collection from java.util.concurrent package. Connection class may be mocked. The pool should be threadsafe and lazy initialized.
Initialize pool with 5 sizes. Load Connection Pool using threads and Thread Pool(7 threads). 5 threads should be able to get the connection. 2 Threads should wait for the next available connection. The program should wait as well.
Implement 4th part but with IFuture and CompletableStage.
* */