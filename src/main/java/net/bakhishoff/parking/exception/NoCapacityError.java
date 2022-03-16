package net.bakhishoff.parking.exception;

/**
 * @author Ulphat
 */
public class NoCapacityError extends RuntimeException {
    public NoCapacityError() {
    }

    public NoCapacityError(String message) {
        super(message);
    }

    public NoCapacityError(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCapacityError(Throwable cause) {
        super(cause);
    }

    public NoCapacityError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
