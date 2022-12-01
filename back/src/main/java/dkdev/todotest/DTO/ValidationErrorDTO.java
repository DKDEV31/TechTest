package dkdev.todotest.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
public class ValidationErrorDTO {
    private final String  message;
    private final HashMap<String, String> constraintViolations;

    public ValidationErrorDTO(String message, HashMap<String,String> constraintViolations) {
        this.message = message;
        this.constraintViolations = constraintViolations;
    }
}
