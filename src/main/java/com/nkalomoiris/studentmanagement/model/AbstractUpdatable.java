package com.nkalomoiris.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

@MappedSuperclass
public abstract class AbstractUpdatable<T> extends AbstractPersistable<T> {

    @Column(name = "updated_at")
    protected Instant updatedAt;

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void onPrePersist() {
        super.onPrePersist();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onPreUpdate() {
        // Inject clock instance
        updatedAt = Instant.now();
    }
}
