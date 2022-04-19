package main.java.phone;

import main.java.interfaces.IPrintName;

import java.util.Date;
import java.util.Objects;
import static main.java.phone.Main.LOGGER;


public abstract class Phone {
    private Battery battery;
    private Screen screen;
    private String model;
    private String message;
    private static int count;

    static {
        count = 0;
    }

    public Phone() {
    }

    public Phone(Battery battery, Screen screen, String model) {
        this.battery = battery;
        this.screen = screen;
        this.model = model;
        count++;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(battery, phone.battery) && Objects.equals(screen, phone.screen)
                && Objects.equals(model, phone.model) && Objects.equals(message, phone.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(battery, screen, model, message);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "battery=" + battery +
                ", screen=" + screen +
                ", model='" + model + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public abstract void makeCall(Person from, Person to);

    public static void finalCurrentTime() {
        Date date = new Date();
        LOGGER.info("Current time: " + date);
    }
}