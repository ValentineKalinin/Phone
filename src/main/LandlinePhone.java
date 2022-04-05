package main;

import interfaces.IWorkable;
import static main.Main.LOGGER;

public class LandlinePhone extends Phone implements IWorkable {
    static final String operator = "BelTelecom";
    private final Cable cable = new Cable("Cable", 5);

    public LandlinePhone() {
    }

    public LandlinePhone(Battery battery, Screen screen, String model) {
        super(battery, screen, model);
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "LandlinePhone{" +
                "cable = " + cable +
                '}';
    }

    @Override
    public void makeCall(Person from, Person to) {
        LOGGER.info(from.getPersonName() + " call to landline of " + to.getPersonName());
    }

    @Override
    public void workable() {
        System.out.println(getModel() + " is work!");
    }
}
