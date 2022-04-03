package Exceptions;

public class BodyException extends Exception{
    public BodyException() {
    }

    public BodyException(String s) {
        super(s);
    }

    public BodyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BodyException(Throwable throwable) {
        super(throwable);
    }

    public BodyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
