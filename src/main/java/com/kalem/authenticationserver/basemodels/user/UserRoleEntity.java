package com.kalem.authenticationserver.basemodels.user;

import com.kalem.basemodels.CreatedByEntity;
import com.kalem.basemodels.IDEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table( name = "USER_USER_ROLE",
        indexes = {
                @Index( name = "USER_USER_ROLE_I1", columnList = "DELETED" ),
                @Index( name = "USER_USER_ROLE_I2", columnList = "DELETED,ROLE_ID" ),
                @Index( name = "USER_USER_ROLE_I3", columnList = "DELETED,USER_ID" )
        }
)
@Cache( usage = CacheConcurrencyStrategy.READ_WRITE )
@AssociationOverrides( {
        @AssociationOverride( name = "UR.USER_ID", joinColumns = @JoinColumn( name = "USER_ID" ) ),
        @AssociationOverride( name = "R.ROLE_ID", joinColumns = @JoinColumn( name = "ROLE_ID" ) ) } )
public class UserRoleEntity extends CreatedByEntity<Integer> {

    @Id
    @Column( name = "ID" )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return getUser();
    }

    @ManyToOne
    @JoinColumn( name = "USER_ID", nullable = false )
    private UserEntity user;

    @ManyToOne
    @JoinColumn( name = "ROLE_ID", nullable = false )
    private RoleEntity role;

    @Override
    public UserRoleEntity clone() throws CloneNotSupportedException {
        UserRoleEntity entity = new UserRoleEntity();
        entity.setUser( this.getUser() );
        entity.setRole( this.getRole() );
        super.clone( entity );
        return entity;
    }
}
