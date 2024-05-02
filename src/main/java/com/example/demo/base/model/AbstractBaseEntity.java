package com.example.demo.base.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractBaseEntity implements Serializable {
    @Column(name = "UUID")
    private UUID uuid;

    /*@CreatedDate
    @Column(name = "Creation_DATE",nullable = false,updatable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(name = "MODIFICATION_DATE",insertable = false)
    private LocalDate modificationDate;*/


}
