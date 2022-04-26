package exceptions;

public class CallException extends Exception{
    public CallException() {
    }

    public CallException(String message) {
        super(message);
    }

    public CallException(String message, Throwable cause) {
        super(message, cause);
    }

    public CallException(Throwable cause) {
        super(cause);
    }

    public CallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
