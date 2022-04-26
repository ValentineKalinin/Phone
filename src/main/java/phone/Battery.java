package phone;

import exceptions.BatteryCapacityException;

import java.util.Objects;

import static phone.Main.LOGGER;

public class Battery {
    private int capacity;
    private String brand;

    public Battery() {

    }

    public Battery(int capacity, String brand) {
        this.capacity = capacity;
        this.brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws BatteryCapacityException {
        if (capacity >= 0)
            this.capacity = capacity;
        else
            throw new BatteryCapacityException("Capacity of Battery is incorrect");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Battery)) return false;
        Battery battery = (Battery) o;
        return capacity == battery.capacity && Objects.equals(brand, battery.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, brand);
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

    public void deterioration(String nameOfPerson, int capacityOfBattery) {
        double percent = (Math.random() * 500);
        LOGGER.info("Deterioration of " + nameOfPerson + "'s battery: " +
                (int) ((capacityOfBattery - percent) / capacityOfBattery * 100) + "%");
    }

    public void workTime(String nameOfPerson) {
        LOGGER.info("Work time of " + nameOfPerson + "'s phone battery with watching Youtube: " +
                this.capacity / 500 + " hours");
    }
}
