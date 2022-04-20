package phone;

import enums.PhoneBrands;
import enums.Days;
import enums.ShopWorkTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static phone.Main.LOGGER;
// добавить интерфейсф
// dобавить лямбды
public class Shopper extends Person {
    private List<PhoneBrands> phoneTaste = new ArrayList<>();

    public Shopper() {

    }

    public Shopper(List<PhoneBrands> phoneTaste) {
        this.phoneTaste = phoneTaste;
    }

    @Override
    public String toString() {
        return "Shopper{" +
                "phoneTaste=" + phoneTaste +
                '}';
    }

    public ArrayList<PhoneBrands> getPhoneTaste() {
        return (ArrayList<PhoneBrands>) phoneTaste;
    }

    public void setPhoneTaste(List<PhoneBrands> phoneTaste) {
        this.phoneTaste = phoneTaste;
    }

    public void addToBookTaste(PhoneBrands t) {
        phoneTaste.add(t);
    }

    public void printBookTaste(List<PhoneBrands> myArray) {
        myArray.forEach(LOGGER::info);
    }

    public void recommendActivity() {
        LOGGER.info("What day of the week do you want to come to the store?");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        Days d = Days.valueOf(option.toUpperCase());
        switch (d) {
            case MONDAY:
            case TUESDAY:
                ShopWorkTime.MORNING_WORKING.info();
                break;
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                ShopWorkTime.FULL_TIME_WORK.info();
                break;
            case SATURDAY:
                ShopWorkTime.EVENING_WORKING.info();
                break;
            default:
                LOGGER.info("Sorry! Sunday is a day off");
                break;
        }
    }

    public void recommendPhoneBrand(Shopper shopper) {
        ArrayList<PhoneBrands> taste = shopper.getPhoneTaste();
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
                // создать эксепшен - нет такого девайса і обработать в catch
            } catch (Exception e) {
                LOGGER.info("Sorry, we don't have any phone model you like in the store");
            }
        }
    }
}
