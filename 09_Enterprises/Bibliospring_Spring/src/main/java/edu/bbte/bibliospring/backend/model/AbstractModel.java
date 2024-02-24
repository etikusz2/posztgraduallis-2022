package edu.bbte.bibliospring.backend.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractModel {
    @Column(name = "uid")
    private String uid;

    public String getUid() {
        ensureUid();
        return uid;
    }

    private void ensureUid(){
        if(uid == null)
            uid = UUID.randomUUID().toString();
    }

    @PrePersist
    public void prePersist(){
        ensureUid();
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractModel that = (AbstractModel) o;
        return getUid().equals(that.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }

    @Override
    public String toString(){
        return uid + " ";
    }
}
