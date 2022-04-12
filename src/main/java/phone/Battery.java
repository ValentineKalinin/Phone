package main.java.phone;

import main.java.exceptions.BatteryCapacityException;

public class Battery {
    private int capacity;
    private String brand;

    public Battery(int capacity, String brand) throws BatteryCapacityException {
        if (capacity <= 0) {
            throw new BatteryCapacityException("Capacity of Battery is incorrect");
        }
        this.capacity = capacity;
        this.brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws BatteryCapacityException {
        if (capacity <= 0) {
            throw new BatteryCapacityException("Capacity of Battery is incorrect");
        }
        this.capacity = capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "capacity = " + capacity +
                ", brand = '" + brand + '\'' +
                '}';
    }

    public String deterioration(String nameOfPerson, int capacityOfBattery) {
        double percent = (Math.random() * 500);
        return ("Deterioration of " + nameOfPerson + "'s battery: " +
                (int) ((capacityOfBattery - percent) / capacityOfBattery * 100) + "%");
    }

    public String workTime(String nameOfPerson) {
        return ("Work time of " + nameOfPerson + "'s phone battery with watching Youtube: " +
                this.capacity / 500 + " hours");
    }
}
