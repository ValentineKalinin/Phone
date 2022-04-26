package exceptions;

public class CableLengthException extends Exception {
    public CableLengthException() {
    }

    public CableLengthException(String message) {
        super(message);
    }

    public CableLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public CableLengthException(Throwable cause) {
        super(cause);
    }

    public CableLengthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}