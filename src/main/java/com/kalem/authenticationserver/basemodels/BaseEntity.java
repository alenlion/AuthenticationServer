package com.kalem.authenticationserver.basemodels;


import com.kalem.enums.DeletedType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@DynamicUpdate
@DynamicInsert
public abstract class BaseEntity implements Cloneable, Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE", nullable = false)
    @LastModifiedDate
    @Version
    private Date modifiedDate = new Date();

    @Type( type = "com.kalem.enums.DeletedTypeValue" )
    @Column( name = "DELETED", columnDefinition = "smallint", nullable = false, length = 1 )
    private DeletedType deleted = DeletedType.FALSE;

    protected void clone(BaseEntity model) throws CloneNotSupportedException {
        model.setCreatedDate(this.getCreatedDate());
        model.setModifiedDate(this.getModifiedDate());
        model.setDeleted(this.getDeleted());
    }
}