package exceptions;

public class BodyCharacteristicsException extends Exception{
    public BodyCharacteristicsException() {
    }

    public BodyCharacteristicsException(String s) {
        super(s);
    }

    public BodyCharacteristicsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BodyCharacteristicsException(Throwable throwable) {
        super(throwable);
    }

    public BodyCharacteristicsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
