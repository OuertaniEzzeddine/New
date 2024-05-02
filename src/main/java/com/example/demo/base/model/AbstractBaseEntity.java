package com.example.demo.base.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;



import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractBaseEntity implements Serializable {
    @Column(name = "UUID")
    private UUID uuid = UUID.randomUUID(); 


    @JsonFormat(pattern = "dd-MM-yyyy 'at' HH:mm")
    @Column(name = "INSERT_DATE",updatable = false)
    private LocalDateTime insertDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd-MM-yyyy 'at' HH:mm")
    @Column(name = "LAST_ACCESS_DATE")
    private LocalDateTime lastAccessDateTime = LocalDateTime.now();


    @JsonFormat(pattern = "dd-MM-yyyy 'at' HH:mm")
    @Column(name = "MODIFICATION_DATE")
    private LocalDateTime modificationDate;

    /*@CreatedDate
    @Column(name = "Creation_DATE",nullable = false,updatable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(name = "MODIFICATION_DATE",insertable = false)
    private LocalDate modificationDate;*/


    public void updateModificationDate() {
        this.modificationDate = LocalDateTime.now();
    }

    public void updateLastAccessDateTime() {
        this.lastAccessDateTime = LocalDateTime.now();
    }
}
