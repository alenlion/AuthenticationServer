package com.kalem.authenticationserver.basemodels;


import com.kalem.enums.StatusType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class CreatedByWithStatusEntity<I extends Number> extends CreatedByEntity<I> {

    @Type( type = "com.kalem.enums.StatusTypeValue" )
    @Column( name = "STATUS", columnDefinition = "smallint default 1", nullable = false, length = 1 )
    private StatusType status = StatusType.ACTIVE;

    protected void clone(CreatedByWithStatusEntity entity) throws CloneNotSupportedException {
        entity.setStatus(this.getStatus());
        super.clone(entity);
    }

}
