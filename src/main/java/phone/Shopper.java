package main.java.phone;

import main.java.enums.Course;
import main.java.enums.Days;
import main.java.enums.PhoneBrands;

import java.util.ArrayList;
import java.util.Scanner;

import static main.java.phone.Main.LOGGER;

public class Shopper extends Person {
    private ArrayList<PhoneBrands> phoneTaste = new ArrayList<>();

    public Shopper() {

    }

    public Shopper(ArrayList<PhoneBrands> phoneTaste) {
        this.phoneTaste = phoneTaste;
    }

    @Override
    public String toString() {
        return "Shopper{" +
                "phoneTaste=" + phoneTaste +
                '}';
    }

    public ArrayList<PhoneBrands> getPhoneTaste() {
        return phoneTaste;
    }

    public void setPhoneTaste(ArrayList<PhoneBrands> phoneTaste) {
        this.phoneTaste = phoneTaste;
    }

    public void addToBookTaste(PhoneBrands t) {
        phoneTaste.add(t);
    }

    public void printBookTaste(ArrayList<PhoneBrands> myArray) {
        myArray.stream().forEach(taste -> LOGGER.info(taste));
    }

    public void recommendActivity() {
        LOGGER.info("What day of the week do you want to come to the store?");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        Days d = Days.valueOf(option.toUpperCase());
        switch (d) {
            case MONDAY:
            case TUESDAY:
                Course.MORNING_WORKING.info();
                break;
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                Course.FULL_TIME_WORK.info();
                break;
            case SATURDAY:
                Course.EVENING_WORKING.info();
                break;
            default:
                LOGGER.info("You should choose an option between Monday and Saturday");
                break;
        }
    }

    public void recommendPhoneBrand(Object shopper) {
        ArrayList<PhoneBrands> taste = ((Shopper) shopper).getPhoneTaste();
        for (PhoneBrands x : taste) {
            try {
                switch (x) {
                    case APPLE:
                        LOGGER.info("If you like Apple you can buy iPhone 12 Pro Max");
                        break;
                    case SAMSUNG:
                        LOGGER.info("If you like Samsung you can buy Samsung Galaxy S21+");
                        break;
                    case XIAOMI:
                        LOGGER.info("If you like Xiaomi you can buy Mi Note 11");
                        break;
                    case HUAWEI:
                        LOGGER.info("If you like Huawei you can buy Huawei Mate 20 Pro");
                        break;
                    default:
                        LOGGER.info("Sorry, we don't have any " + x + " phone in the store");
                        break;
                }
            } catch (Exception e) {
                LOGGER.info("Sorry, we don't have any phone model you like in the store");
            }
        }
    }
}
