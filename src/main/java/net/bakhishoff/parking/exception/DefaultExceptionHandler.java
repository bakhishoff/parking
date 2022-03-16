package net.bakhishoff.parking.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ulphat
 */
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
                                                                  @Nullable HttpHeaders headers,
                                                                  @Nullable HttpStatus status,
                                                                  @Nullable WebRequest request) {
        return processErrorMessage(new ExceptionBody(getErrorsFromBindingResult(ex.getBindingResult())),
                                   HttpStatus.BAD_REQUEST);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleBindException(@NonNull BindException ex,
                                                         @Nullable HttpHeaders headers,
                                                         @Nullable HttpStatus status,
                                                         @Nullable WebRequest request) {
        return processErrorMessage(new ExceptionBody(getErrorsFromBindingResult(ex)), HttpStatus.BAD_REQUEST);
    }

    private List<IncorrectField> getErrorsFromBindingResult(BindingResult result) {
        return result.getFieldErrors()
                     .stream()
                     .map(error -> new IncorrectField(error.getField(), error.getDefaultMessage()))
                     .sorted(Comparator.comparing(IncorrectField::getPath))
                     .collect(Collectors.toList());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return processErrorMessage(new ExceptionBody(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoDataFoundException.class)
    protected ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex) {
        return processErrorMessage(new ExceptionBody(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<Object> handleNoDataFoundException(EntityNotFoundException ex) {
        return processErrorMessage(new ExceptionBody(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        return processErrorMessage(new ExceptionBody(ex.getConstraintViolations()
                                                       .stream()
                                                       .map(v -> new IncorrectField(v.getPropertyPath().toString(),
                                                                                    v.getMessage()))
                                                       .sorted(Comparator.comparing(IncorrectField::getPath))
                                                       .collect(Collectors.toList())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Throwable.class)
    protected ResponseEntity<Object> handleGenericErrors(Throwable throwable) {
        log.warn("Handled generic exception", throwable);
        return processErrorMessage(new ExceptionBody(throwable.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> processErrorMessage(ExceptionBody body, HttpStatus status) {
        return ResponseEntity.status(status).body(body);
    }
}
