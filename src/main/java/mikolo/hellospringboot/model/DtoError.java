package mikolo.hellospringboot.model;

import lombok.Data;

@Data
public class DtoError {

    private String message;
    private String exceptionClass;
}
