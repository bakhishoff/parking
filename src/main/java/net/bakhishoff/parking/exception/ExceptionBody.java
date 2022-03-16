package net.bakhishoff.parking.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Ulphat
 */
@Data
@NoArgsConstructor
public class ExceptionBody {
    private String message;
    private List<IncorrectField> incorrectFields;
    private Date timestamp = new Date();

    public ExceptionBody(String message) {
        this.message = message;
    }

    public ExceptionBody(List<IncorrectField> incorrectFields) {
        this.incorrectFields = incorrectFields;
    }

    public ExceptionBody(String message, List<IncorrectField> incorrectFields) {
        this.message = message;
        this.incorrectFields = incorrectFields;
    }
}
