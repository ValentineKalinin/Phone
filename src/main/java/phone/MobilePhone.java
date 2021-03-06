package phone;

import exceptions.CallException;
import exceptions.MessageException;
import interfaces.service.IPrintName;
import interfaces.service.IShortMessageService;
import interfaces.service.IWorkable;

import java.util.Objects;

import static phone.Main.LOGGER;

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
    public void makeCall(Person from, Person to) throws CallException {
        if (!from.equals(to)) {
            IPrintName printName = (fPerson, sPerson) -> LOGGER.info(fPerson + " call to " + sPerson + " by " + phoneModel);
            printName.print(from.getPersonName(), to.getPersonName());
        } else
            throw new CallException("You can't make call from " + from.getPersonName() + " to " + to.getPersonName());
    }

    @Override
    public void SendMessage(Person from, Person to, String mes) throws MessageException {
        if (!from.equals(to)) {
            IPrintName printName = (fPerson, sPerson) -> LOGGER.info(fPerson + " send message \"" + mes + "\" to " + sPerson + " by " + phoneModel);
            printName.print(from.getPersonName(), to.getPersonName());
        } else
            throw new MessageException("You can't send message from " + from.getPersonName() + " to " + to.getPersonName());
    }

    @Override
    public void workable() {
        LOGGER.info(getModel() + " is work!");
    }
}
