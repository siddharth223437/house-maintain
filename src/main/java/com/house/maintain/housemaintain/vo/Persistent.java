package com.house.maintain.housemaintain.vo;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class Persistent {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "created_ts")
    @CreatedDate
    private LocalDateTime createdTimeStamp;

    @Column(name = "updated_ts")
    @LastModifiedDate
    private LocalDateTime updatedTimeStamp;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;

    public long getId() {
        return id;
    }

    public LocalDateTime getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public LocalDateTime getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
}
