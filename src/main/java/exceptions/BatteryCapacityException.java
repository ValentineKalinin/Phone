package main.java.exceptions;

public class BatteryCapacityException extends Exception{
    public BatteryCapacityException() {
    }

    public BatteryCapacityException(String s) {
        super(s);
    }

    public BatteryCapacityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BatteryCapacityException(Throwable throwable) {
        super(throwable);
    }

    public BatteryCapacityException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
