package main.java.phone;

import main.java.interfaces.IPrintName;
import main.java.interfaces.IShortMessageService;
import main.java.interfaces.IWorkable;

import static main.java.phone.Main.LOGGER;

import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;

public class MobilePhone extends Phone implements IShortMessageService, IWorkable {
    private String unlockMethod;
    private String phoneModel;

    public MobilePhone() {
    }

    public MobilePhone(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
        this.phoneModel = model;
    }

    public String getUnlockMethod() {
        return unlockMethod;
    }

    public void setUnlockMethod(String unlockMethod) {
        this.unlockMethod = unlockMethod;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String model) {
        this.phoneModel = model;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "unlockMethod='" + unlockMethod + '\'' +
                ", model='" + phoneModel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobilePhone)) return false;
        if (!super.equals(o)) return false;
        MobilePhone that = (MobilePhone) o;
        return unlockMethod.equals(that.unlockMethod) && phoneModel.equals(that.phoneModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unlockMethod, phoneModel);
    }

    @Override
    public void makeCall(Person from, Person to) {
        IPrintName printName = (fPerson, sPerson) -> LOGGER.info(fPerson + " call to " + sPerson + " by " + phoneModel);
        printName.print(from.getPersonName(), to.getPersonName());
    }

    @Override
    public void SendMessage(Person from, Person to, String mes) {
        IPrintName printName = (fPerson, sPerson) -> LOGGER.info(fPerson + " send message \"" + mes + "\" to " + sPerson + " by " + phoneModel);
        printName.print(from.getPersonName(), to.getPersonName());
    }

    @Override
    public void workable() {
        LOGGER.info(getModel() + " is work!");
    }

    public static <T> void showOrder(List<T> list) {
        for (T element : list) {
            LOGGER.info(element);
        }
    }
}
