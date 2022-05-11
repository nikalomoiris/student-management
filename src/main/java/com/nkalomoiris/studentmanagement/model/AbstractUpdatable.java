package com.nkalomoiris.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

@MappedSuperclass
public abstract class AbstractUpdatable<T> extends AbstractPersistable<T> {

    @Column(name = "modified_at")
    protected Instant modifiedAt;

    public Instant getModifieddAt() {
        return modifiedAt;
    }

    void setModifieddAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @PrePersist
    public void onPrePersist() {
        super.onPrePersist();
        modifiedAt = createdAt;
    }

    @PreUpdate
    public void onPreUpdate() {
        // Inject clock instance
        modifiedAt = Instant.now();
    }
}
