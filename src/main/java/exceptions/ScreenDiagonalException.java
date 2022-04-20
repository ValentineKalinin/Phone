package exceptions;

public class ScreenDiagonalException extends Exception {
    public ScreenDiagonalException() {
    }

    public ScreenDiagonalException(String s) {
        super(s);
    }

    public ScreenDiagonalException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ScreenDiagonalException(Throwable throwable) {
        super(throwable);
    }

    public ScreenDiagonalException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
