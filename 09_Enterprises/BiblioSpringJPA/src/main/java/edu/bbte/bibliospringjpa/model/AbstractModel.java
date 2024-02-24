package edu.bbte.bibliospringjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractModel {
    @Column(name = "uuid", nullable = false, unique = true, length = 36)
    private String uuid;

    public String getUuid() {
        ensureUuid();
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private void ensureUuid() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
    }

    @PrePersist
    public void prePersist() {
        ensureUuid();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractModel that = (AbstractModel) o;
        return Objects.equals(getUuid(), that.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}
