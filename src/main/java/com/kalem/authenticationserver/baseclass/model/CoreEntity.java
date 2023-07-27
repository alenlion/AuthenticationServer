package com.kalem.authenticationserver.baseclass.model;


import com.kalem.authenticationserver.baseclass.enums.DeletedType;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class CoreEntity implements Serializable {

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "CREATE_DATE", nullable = false, updatable = false )
    private LocalDateTime createdDate;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "MODIFY_DATE" )
    private LocalDateTime modifiedDate;

    @Column( name = "DELETED", columnDefinition = "smallint", nullable = false, length = 1 )
    private DeletedType deleted = DeletedType.FALSE;

    @PrePersist
    public void setCreationDateTime() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void setChangeDateTime() {
        this.modifiedDate = LocalDateTime.now();
    }
}