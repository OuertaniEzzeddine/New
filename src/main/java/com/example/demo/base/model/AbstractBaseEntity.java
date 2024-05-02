package com.example.demo.base.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

=======
import jakarta.persistence.*;
>>>>>>> 7fa0388e06274c510af2530e834828da2cf874a1
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractBaseEntity implements Serializable {
    @Column(name = "UUID")
    private UUID uuid = UUID.randomUUID(); 

<<<<<<< HEAD
    @JsonFormat(pattern = "dd-MM-yyyy 'at' HH:mm")
    @Column(name = "INSERT_DATE",updatable = false)
    private LocalDateTime insertDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd-MM-yyyy 'at' HH:mm")
    @Column(name = "LAST_ACCESS_DATE")
    private LocalDateTime lastAccessDateTime = LocalDateTime.now();


    @JsonFormat(pattern = "dd-MM-yyyy 'at' HH:mm")
    @Column(name = "MODIFICATION_DATE")
    private LocalDateTime modificationDate;
=======
    /*@CreatedDate
    @Column(name = "Creation_DATE",nullable = false,updatable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(name = "MODIFICATION_DATE",insertable = false)
    private LocalDate modificationDate;*/
>>>>>>> 7fa0388e06274c510af2530e834828da2cf874a1

    public void updateModificationDate() {
        this.modificationDate = LocalDateTime.now();
    }

    public void updateLastAccessDateTime() {
        this.lastAccessDateTime = LocalDateTime.now();
    }
}
