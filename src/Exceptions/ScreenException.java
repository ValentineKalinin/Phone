package Exceptions;

public class ScreenException extends Exception {
    public ScreenException() {
    }

    public ScreenException(String s) {
        super(s);
    }

    public ScreenException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ScreenException(Throwable throwable) {
        super(throwable);
    }

    public ScreenException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
