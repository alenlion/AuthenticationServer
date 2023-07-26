package com.kalem.authenticationserver.basemodels.provider;

import com.kalem.sharedclass.basemodels.CreatedByEntity;
import com.kalem.sharedclass.basemodels.IDEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "PROVIDER_ROLE")
@XStreamAlias("role")
@XmlAccessorType(XmlAccessType.FIELD)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProviderRoleEntity extends CreatedByEntity<Integer> {

    public static final String ROLE_PROVIDER = "ROLE_PROVIDER";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return null;
    }

    @Column(name = "NAME", nullable = false, length = 60)
    private String name;

    public ProviderRoleEntity() {
        super();
    }

    public ProviderRoleEntity(String name) {
        super();
        this.name = name;
    }

    @Override
    public ProviderRoleEntity clone() throws CloneNotSupportedException {
        ProviderRoleEntity entity = new ProviderRoleEntity();
        entity.setID(this.getID());
        entity.setName(this.getName());
        super.clone(entity);
        return entity;
    }

}
