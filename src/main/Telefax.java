package main;

import interfaces.IFax;
import interfaces.IWorkable;
import static main.Main.LOGGER;

public class Telefax extends Phone implements IFax, IWorkable {
    public Telefax() {
    }

    public Telefax(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }


    @Override
    public void makeCall(Person from, Person to) {
        System.out.println("Can't make call");
    }

    @Override
    public void SendFax(Person from, Person to, String fax) {
        LOGGER.info(to.getPersonName() + " get fax \"" + fax + "\" from " + from.getPersonName());
    }

    @Override
    public void workable() {
        LOGGER.info(getModel() + " is work!");
    }
}
