package Exceptions;

public class BatteryException extends Exception{
    public BatteryException() {
    }

    public BatteryException(String s) {
        super(s);
    }

    public BatteryException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BatteryException(Throwable throwable) {
        super(throwable);
    }

    public BatteryException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
