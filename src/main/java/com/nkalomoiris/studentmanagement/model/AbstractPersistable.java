package com.nkalomoiris.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
public abstract class AbstractPersistable<T> implements Serializable {

    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;

    public abstract T getId();

    public abstract void setId(T id);

    public Instant getCreatedAt() {
        return createdAt;
    }

    protected void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void onPrePersist() {
        // Inject clock instance
        Instant now = Instant.now();
        if (createdAt == null) {
            createdAt = now;
        }
    }

}
