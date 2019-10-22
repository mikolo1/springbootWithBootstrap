package mikolo.hellospringboot.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {

    @Getter
    private Long id;

    public EntityNotFoundException(Long id) {
        super("Entity with id "+id+" not exist.");
        this.id = id;
    }
}
