package edu.bbte.bibliospring.backend.model;

import java.util.Objects;
import java.util.UUID;

public abstract class AbtractModel {
    private String uid;

    public String getUid() {
        if (uid == null) {
            uid = UUID.randomUUID().toString();
        }
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbtractModel that = (AbtractModel) o;
        return getUid().equals(that.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }

    @Override
    public String toString() {
        return uid + " ";
    }
}
