package com.kalem.authenticationserver.basemodels.provider;

import com.kalem.sharedclass.basemodels.CreatedByEntity;
import com.kalem.sharedclass.basemodels.IDEntity;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "PROVIDER_PROVIDER_ROLE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProviderProviderRoleEntity extends CreatedByEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return null;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVIDER_ID", nullable = false)
    private ProviderEntity provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private ProviderRoleEntity role;

    @Override
    public ProviderProviderRoleEntity clone() throws CloneNotSupportedException {
        ProviderProviderRoleEntity entity = new ProviderProviderRoleEntity();
        entity.setProvider(this.getProvider());
        entity.setRole(this.getRole());
        super.clone(entity);
        return entity;
    }
}
