package com.kalem.authenticationserver.basemodels.user;

import com.kalem.sharedclass.basemodels.CreatedByWithStatusEntity;
import com.kalem.sharedclass.basemodels.IDEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table( name = "USER_ADDRESS",
        indexes = {
                @Index( name = "USER_ADDRESS_I1", columnList = "DELETED" ),
                @Index( name = "USER_ADDRESS_I2", columnList = "DELETED,USER_ID" ),
        }
)
@Cache( usage = CacheConcurrencyStrategy.READ_WRITE )
public class UserAddressEntity extends CreatedByWithStatusEntity<Integer> {

    @Id
    @Column( name = "ID" )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return null;
    }

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "USER_ID", nullable = false )
    private UserEntity user;

    @Column( name = "ADDRESS_LINE1", length = 254 )
    private String addressLine1;

    @Column( name = "ADDRESS_LINE2", length = 254 )
    private String addressLine2;

    @Column( name = "ADDRESS_LINE3", length = 254 )
    private String addressLine3;

    @Column( name = "ADDRESS_LINE4", length = 254 )
    private String addressLine4;

    @Column( name = "CITY", length = 100 )
    private String city;

    @Column( name = "REGION", length = 100 )
    private String region;

    @Column( name = "POSTAL_CODE", length = 100 )
    private String postalCode;

    @Column( name = "LONGITUDE" )
    private Double longitude;

    @Column( name = "LATITUDE" )
    private Double latitude;

    @Override
    public UserAddressEntity clone() throws CloneNotSupportedException {
        UserAddressEntity entity = new UserAddressEntity();
        entity.setUser( this.getUser() );
        entity.setAddressLine1( this.getAddressLine1() );
        entity.setAddressLine2( this.getAddressLine2() );
        entity.setAddressLine3( this.getAddressLine3() );
        entity.setAddressLine4( this.getAddressLine4() );
        entity.setCity( this.getCity() );
        entity.setRegion( this.getRegion() );
        entity.setPostalCode( this.getPostalCode() );
        entity.setLatitude( this.getLatitude() );
        entity.setLongitude( this.getLongitude() );
        super.clone( entity );
        return entity;
    }

}
