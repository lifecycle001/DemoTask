package com.example.Blog.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractTimestampEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated"/*, nullable = false*/)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public AbstractTimestampEntity() {
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
