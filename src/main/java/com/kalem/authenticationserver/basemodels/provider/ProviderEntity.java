package com.kalem.authenticationserver.basemodels.provider;

import com.kalem.sharedclass.basemodels.CreatedByEntity;
import com.kalem.sharedclass.basemodels.IDEntity;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@SuppressWarnings("serial")
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "PROVIDER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProviderEntity extends CreatedByEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return null;
    }

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "PASSWRD", nullable = false, length = 100)
    private String password;

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;

    /**
     * need to specify column names by hand because of JDBCRealm compatibility
     */
    @ManyToMany
    @JoinTable(
            name = "PROVIDER_PROVIDER_ROLE",
            joinColumns = {@JoinColumn(name = "PROVIDER_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", nullable = false)}
    )
    private Collection<ProviderRoleEntity> roles = new ArrayList();

    public ProviderEntity() {
        super();
    }

    public ProviderEntity(String name, String password, String description) {
        super();
        this.name = name;
        this.password = password;
        this.description = description;
    }

    @Override
    public ProviderEntity clone() throws CloneNotSupportedException {
        ProviderEntity entity = new ProviderEntity();
        entity.setID(this.ID);
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setPassword(this.password);
        entity.setDeleted(this.getDeleted());
        entity.setRoles(this.roles);
        super.clone(entity);
        return entity;
    }
}
