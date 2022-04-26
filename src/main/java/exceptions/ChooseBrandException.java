package exceptions;

public class ChooseBrandException extends Exception {
    public ChooseBrandException() {
    }

    public ChooseBrandException(String message) {
        super(message);
    }

    public ChooseBrandException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChooseBrandException(Throwable cause) {
        super(cause);
    }

    public ChooseBrandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
