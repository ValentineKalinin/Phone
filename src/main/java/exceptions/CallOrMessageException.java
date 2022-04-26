package exceptions;

public class CallOrMessageException extends Exception {
    public CallOrMessageException() {
    }

    public CallOrMessageException(String message) {
        super(message);
    }

    public CallOrMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public CallOrMessageException(Throwable cause) {
        super(cause);
    }

    public CallOrMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
