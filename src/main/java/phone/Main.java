package phone;

import enums.PhoneBrands;
import enums.Sex;
import exceptions.BodyCharacteristicsException;
import exceptions.CallOrMessageException;
import exceptions.ScreenDiagonalException;
import interfaces.functional.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final String ALISON_NAME = "Alison";
    private static final String SCOTT_NAME = "Scott";
    private static final String STILES_NAME = "Stiles";

    Battery batterySamsung = new Battery(4000, "Samsung");
    Battery batteryApple = new Battery(3500, "Apple");
    Battery batteryXiaomi = new Battery(-5000, "Xiaomi");
    Battery batterFax = new Battery(550, "Li-ion");

    Person alison = new Person(ALISON_NAME, "Hi, I'm Alison", Sex.WOMAN);
    Person scott = new Person(SCOTT_NAME, "Hi, I'm Scott", Sex.MAN);
    Person stiles = new Person(STILES_NAME, "Hi, I'm Stiles", Sex.MAN);

    Screen screenSamsung = new Screen(6.7, "OLED");
    Screen screenApple = new Screen(6.2, "IPS");
    Screen screenXiaomi = new Screen(5.9, "IPS");
    Screen screenFax = new Screen(1.6, "Crystal");

    MobilePhone samsungPhone = new MobilePhone(batterySamsung, screenSamsung, "Samsung Fold 3");
    MobilePhone applePhone = new MobilePhone(batteryApple, screenApple, "iPhone 13 Pro Max");
    LandlinePhone homePhone = new LandlinePhone(batteryApple, screenSamsung, "Samsung F535");
    MobilePhone xiaomiPhone = new MobilePhone(batteryXiaomi, screenXiaomi, "Xiaomi Mi 11 Lite");
    Telefax telefax = new Telefax(batterFax, screenFax, "HP Pavilion");

    private void runBasicClass() throws ScreenDiagonalException {
        samsungPhone.setUnlockMethod("Fingerprint");
        applePhone.setUnlockMethod("Face ID");
        xiaomiPhone.setUnlockMethod("PIN code");

        LOGGER.info("Enter username and password for computer.Macbook");
        LOGGER.info(screenApple.ppiOfScreen(scott.getPersonName()));
        LOGGER.info(samsungPhone.getModel());
        LOGGER.info(applePhone.getBattery());
        LOGGER.info(xiaomiPhone.getBattery());
        LOGGER.info(batteryXiaomi.workTime(alison.getPersonName()));
        LOGGER.info(screenSamsung.workTime(alison.getPersonName(), batterySamsung.getCapacity()));

        LOGGER.info("Model at Apple: " + applePhone.getModel());
        LOGGER.info(applePhone.getModel() + " unlock by " + applePhone.getUnlockMethod());
        LOGGER.info("Screen at " + samsungPhone.getModel() + ": " + samsungPhone.getScreen());

        LOGGER.info(batterySamsung.deterioration(alison.getPersonName(), batterySamsung.getCapacity()));
        LOGGER.info(batterySamsung.workTime(alison.getPersonName()));

        try {
            samsungPhone.makeCall(scott, alison);
            telefax.makeCall(scott, alison);
            applePhone.SendMessage(alison, scott, alison.getMessage());
            telefax.SendFax(scott, alison, scott.getMessage());
        } catch (CallOrMessageException e) {
            LOGGER.error(e.getMessage(), e);
        }


        samsungPhone.workable();
        telefax.workable();
        homePhone.workable();

        LOGGER.info(samsungPhone.getScreen().getTechnologyOfScreen().
                equals(xiaomiPhone.getScreen().getTechnologyOfScreen()));

        Phone.finalCurrentTime();
        LOGGER.info(LandlinePhone.operator);

        screenSamsung.setResolutionOfScreen(1125, 2436);
        screenSamsung.getScreenSize();
    }

    private void runEnum() throws BodyCharacteristicsException {
        scott.BODY_MASS_INDEX(1.9, 85);
        alison.BODY_MASS_INDEX(1.65, 52);

        ArrayList<PhoneBrands> stilesPhoneTaste = new ArrayList<>();
        stilesPhoneTaste.add(PhoneBrands.APPLE);
        stilesPhoneTaste.add(PhoneBrands.SAMSUNG);
        Shopper stilesShopper = new Shopper(stilesPhoneTaste);
        stilesShopper.recommendPhoneBrand(stilesShopper);
        stilesShopper.printBookTaste(stilesPhoneTaste);
        stilesShopper.recommendActivity();
    }

    private void runCollections() {
        LOGGER.info("Number of phones: " + Phone.getCount());

        NewLinkedList<Phone> allPhones = new NewLinkedList<>();
        allPhones.addFirst(applePhone);
        allPhones.addFirst(samsungPhone);
        allPhones.addFirst(xiaomiPhone);
        allPhones.addLast(telefax);
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
    }

    final Random random = new Random();
    private static final int BOUND = 10;
    private static final String SAMSUNG = "Samsung ";
    private static final String SAMMES = "Hi i'm ";
    private static final String UNLOCK = "Unlock by: ";
    private static final int COUNT_OF_SAMSUNG = 10;

    public List<MobilePhone> createPhoneList() {
        List<MobilePhone> order = new LinkedList<>();
        IntStream.range(0, COUNT_OF_SAMSUNG).mapToObj(i -> new MobilePhone()).forEach(phone -> {
            phone.setMessage(SAMMES + random.nextInt(BOUND));
            phone.setPhoneModel(SAMSUNG + random.nextInt(BOUND));
            phone.setUnlockMethod(UNLOCK + random.nextInt(BOUND));
            order.add(phone);
        });
        return order;
    }

    private void runCountWords() throws IOException {
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
    }

    private void runAnalyzeClass(Object o) {
        Class<?> aClass = o.getClass();
        LOGGER.info("Name of class: " + aClass);
        LOGGER.info("Fields of class: " + Arrays.toString(aClass.getDeclaredFields()));
        LOGGER.info("Parent class: " + aClass.getSuperclass());
        LOGGER.info("Method of class: " + Arrays.toString(aClass.getDeclaredMethods()));
        LOGGER.info("Constructor of class: " + Arrays.toString(aClass.getConstructors()));
    }

    private void runSolvdLabaThreads() {
        int COUNT_OF_THREADS = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_OF_THREADS);
        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            Runnable r = new ThreadInfo();
            executorService.submit(r);
        }
        executorService.shutdown();
    }

    private void runFunctionalInterface() {
        IPersonCreate<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Pen", "Hi! I'm Peter", Sex.MAN);
        int FIRST_NUMBER = 5;
        int SECOND_NUMBER = -15;
        int THIRD_NUMBER = 2;
        String TEST_VALUE = "7776688";
        LOGGER.info(person);

        ISplitString splitString = (firstWord, secondWord) -> (firstWord + "***" + secondWord);
        LOGGER.info(splitString.split(person.getPersonName(), person.getPersonSurname()));

        IGetAverage getAverage = (firstNumber, secondNumber, thirdNumber) -> (firstNumber + secondNumber) / thirdNumber;
        LOGGER.info(getAverage.result(FIRST_NUMBER, SECOND_NUMBER, THIRD_NUMBER));

        ICompare myCompare = x -> x > 0;
        LOGGER.info(myCompare.test(FIRST_NUMBER));
        LOGGER.info(myCompare.test(SECOND_NUMBER));

        IFunction<String, Integer> valueConverter = Integer::valueOf;
        LOGGER.info(valueConverter.apply(TEST_VALUE));
    }

    public static void main(String[] args) throws ScreenDiagonalException, IOException, BodyCharacteristicsException {
        Main main = new Main();
        main.runBasicClass();
        main.runEnum();
        main.runCollections();
        main.runCountWords();
        main.runAnalyzeClass(main.samsungPhone);
        main.createPhoneList();
        main.runFunctionalInterface();
        main.runSolvdLabaThreads();
    }

}
/*
mvn exec:java -Dexec.mainClass="phone.Main"

нормальные эксепшионс: обработать чтобы при ошибке все работало дальше

Lab 8
1. add 5 interfaces and lambda function for them
2. add 3 streams to the hierarchy

Lab 9
git reset HEAD
Create 2 Threads using Runnable and Thread.
Create Connection Pool. Use collection from java.util.concurrent package.
Connection class may be mocked. The pool should be threadsafe and lazy initialized.
Initialize pool with 5 sizes. Load Connection Pool using threads and Thread Pool(7 threads).
5 threads should be able to get the connection.
2 Threads should wait for the next available connection.
The program should wait as well.
**/