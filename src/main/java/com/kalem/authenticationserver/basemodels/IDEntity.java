package com.kalem.authenticationserver.basemodels;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@Getter
@Setter
@MappedSuperclass
public abstract class IDEntity<I extends Number> extends BaseEntity {

    public IDEntity() {
    }

    public abstract IDEntity clone() throws CloneNotSupportedException;

    //ORACLE Sequence strategy
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROVIDER")
    //@SequenceGenerator(name = "SEQ_PROVIDER", sequenceName = "SEQ_PROVIDER_ID") //, allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public abstract I getID();

    public abstract void setID(I id);

    @Transient
    public abstract IDEntity getParentEntity();

    protected void clone(IDEntity entity) throws CloneNotSupportedException {
        entity.setID(this.getID());
        super.clone(entity);
    }
}
