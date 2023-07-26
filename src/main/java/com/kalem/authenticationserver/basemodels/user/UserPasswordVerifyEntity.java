package com.kalem.authenticationserver.basemodels.user;


import com.kalem.basemodels.IDEntity;
import com.kalem.enums.ReminderStatusType;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table( name = "USER_PASSWORD_VERIFY",
        indexes = {
                @Index( name = "USER_PASSWORD_VERIFY_I1", columnList = "DELETED" ),
                @Index( name = "USER_PASSWORD_VERIFY_I2", columnList = "DELETED,USER_ID" )
        }
)
@Cache( usage = CacheConcurrencyStrategy.READ_WRITE )
public class UserPasswordVerifyEntity extends IDEntity<Integer> {

    @Id
    @Column( name = "ID" )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return getUser();
    }

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "USER_ID", nullable = false )
    private UserEntity user;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "REQUEST_TIME", nullable = false )
    private Date requestTime;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "RESPONSE_TIME" )
    private Date responseTime;

    @Column( name = "TOKEN", length = 2048 )
    private String token;

    @Enumerated( EnumType.ORDINAL )
    @Column( name = "STATUS", nullable = false, length = 12 )
    private ReminderStatusType status;

    @Override
    public UserPasswordVerifyEntity clone() throws CloneNotSupportedException {
        UserPasswordVerifyEntity entity = new UserPasswordVerifyEntity();
        entity.setRequestTime( this.getRequestTime() );
        entity.setResponseTime( this.getResponseTime() );
        entity.setToken( this.getToken() );
        entity.setStatus( this.getStatus() );
        super.clone( entity );
        return entity;
    }
}
