package edu.bbte.bibliospringspringdata.api.exception;

public class NotFoundException extends RuntimeException {
    private final Class type;
    private final Long id;

    public NotFoundException(Class type, Long id) {
        super();
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Class getType() {
        return type;
    }
}
