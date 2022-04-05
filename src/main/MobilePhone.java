package main;

import interfaces.IShortMessageService;
import interfaces.IWorkable;
import static main.Main.LOGGER;

import java.util.Objects;

public class MobilePhone extends Phone implements IShortMessageService, IWorkable {
    private String unlock;

    public MobilePhone() {
    }

    public MobilePhone(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }

    public String getUnlock() {
        return unlock;
    }

    public void setUnlock(String unlock) {
        this.unlock = unlock;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "unlock='" + unlock + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobilePhone that = (MobilePhone) o;
        return Objects.equals(unlock, that.unlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unlock);
    }

    @Override
    public void makeCall(Person from, Person to) {
        LOGGER.info(from.getPersonName() + " call to " + to.getPersonName() + " by landline phone");
    }

    @Override
    public void SendMessage(Person from, Person to, String mes) {
        LOGGER.info(from.getPersonName() + " send message \"" + mes + "\" to " + to.getPersonName());
    }

    @Override
    public void workable() {
        LOGGER.info(getModel() + " is work!");
    }
}
