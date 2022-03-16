package net.bakhishoff.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
    }

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDataFoundException(Throwable cause) {
        super(cause);
    }

    public NoDataFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static NoDataFoundException ofResourceNameAndId(String resourceName, String id) {
        return new NoDataFoundException(String.format("%s with id=%s not found", resourceName, id));
    }
}
