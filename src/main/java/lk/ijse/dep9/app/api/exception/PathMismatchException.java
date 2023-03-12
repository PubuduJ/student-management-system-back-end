package lk.ijse.dep9.app.api.exception;

public class PathMismatchException extends RuntimeException {

    public PathMismatchException(String message) {
        super(message);
    }

    public PathMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

}
