    package net.bakhishoff.parking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ulphat
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncorrectField {
    private String path;
    private String message;
}
