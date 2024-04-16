package com.example.demo.base.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractBaseEntity implements Serializable {
    @Column(name = "UUID")
    private UUID uuid;

    @Column(name = "INSERT_DATE")
    private LocalDate insertDate;

    @Column(name = "MODIFICATION_DATE")
    private LocalDate modificationDate;


}
