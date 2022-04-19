package main.java.phone;

import main.java.interfaces.IFax;
import main.java.interfaces.IPrintName;
import main.java.interfaces.IWorkable;
import static main.java.phone.Main.LOGGER;

public class Telefax extends Phone implements IFax, IWorkable {
    public Telefax() {
    }

    public Telefax(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }


    @Override
    public void makeCall(Person from, Person to) {
        IPrintName printName = (sc, al) -> LOGGER.info(sc + " call to " + al);
        LOGGER.info("Can't make call from " + getModel());
    }

    @Override
    public void SendFax(Person from, Person to, String fax) {
        IPrintName printName = (fPerson, sPerson) -> LOGGER.info(sPerson + " get fax \"" + fax + "\" from " + fPerson + " be fax");
        printName.print(from.getPersonName(), to.getPersonName());
    }

    @Override
    public void workable() {
        LOGGER.info(getModel() + " is work!");
    }
}
