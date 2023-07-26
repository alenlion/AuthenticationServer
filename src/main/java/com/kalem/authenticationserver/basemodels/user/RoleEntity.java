package com.kalem.authenticationserver.basemodels.user;

import com.kalem.sharedclass.basemodels.CreatedByWithStatusEntity;
import com.kalem.sharedclass.basemodels.IDEntity;
import com.kalem.sharedclass.enums.RoleType;
import com.kalem.sharedclass.enums.UserRoleType;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table( name = "USER_ROLE",
        indexes = {
                @Index( name = "USER_ROLE_I1", columnList = "DELETED" ),
                @Index( name = "USER_ROLE_I2", columnList = "DELETED,STATUS" ),
                @Index( name = "USER_ROLE_I3", columnList = "DELETED,TYPE" )
        }
)
@org.hibernate.annotations.Cache( usage = CacheConcurrencyStrategy.READ_WRITE )
public class RoleEntity extends CreatedByWithStatusEntity<Integer> {

    @Id
    @Column( name = "ID" )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return null;
    }

    @Column( name = "CODE", length = 20 )
    private String code;

    @Column( name = "DESCRIPTION", length = 50 )
    private String description;

    @Type( type = "com.kalem.sharedclass.enums.UserRoleTypeValue" )
    @Column( name = "TYPE", columnDefinition = "smallint", nullable = false, length = 1 )
    private UserRoleType type;

    @Type( type = "com.kalem.sharedclass.enums.RoleTypeValue" )
    @Column( name = "ROLE_TYPE", columnDefinition = "smallint", length = 1 )
    private RoleType roleType;

    @Override
    public RoleEntity clone() throws CloneNotSupportedException {
        RoleEntity entity = new RoleEntity();
        entity.setID( this.getID() );
        entity.setCode( this.getCode() );
        entity.setStatus( this.getStatus() );
        super.clone( entity );
        return entity;
    }

}
