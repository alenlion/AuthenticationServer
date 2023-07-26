package com.kalem.authenticationserver.basemodels.user;

import com.kalem.basemodels.CreatedByEntity;
import com.kalem.basemodels.IDEntity;
import com.kalem.enums.ECommerceUserType;
import com.kalem.enums.LocalizationType;
import com.kalem.enums.UserStatusType;
import com.kalem.enums.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "USERS",
        indexes = {
                @Index(name = "USERS_I1", columnList = "DELETED"),
                @Index(name = "USERS_I2", columnList = "DELETED,STATUS,USERNAME")
        })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class UserEntity extends CreatedByEntity<Integer> {

    @Id
    @Column(name = "ID")
    //TODO : @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer ID;

    @Override
    public IDEntity getParentEntity() {
        return null;
    }


    @Column(name = "PASSWRD", nullable = false, length = 250)
    private String password;

    @Column(name = "USERNAME", nullable = false, length = 50)
    private String username;

    @Column(name = "FULL_NAME", nullable = false, length = 100)
    private String fullName;

    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "WORKING_PERIOD_ID")
    private Integer workingPeriodId;

    @Column(name = "BRANCH_ID")
    private Integer branchId;

    @Column(name = "WAREHOUSE_ID")
    private Integer warehouseId;

    @Column(name = "LOGISTICS_WAREHOUSE_ID")
    private Integer logisticsWarehouseId;

    @Transient
    private String fullNameSurname;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "PASSWRD_EXPIRED", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordExpired;

    @Column(name = "LOGIN_TRY", nullable = false)
    private Short loginTry;

    @Enumerated(EnumType.STRING)
    @Column(name = "LANG_TYPE", nullable = false, length = 5)
    private LocalizationType localization = LocalizationType.tr_TR;

    @Type( type = "com.kalem.enums.UserStatusTypeValue" )
    @Column( name = "STATUS", columnDefinition = "smallint", nullable = false, length = 1 )
    private UserStatusType status;

    @Column(name = "LOGIN_DEVICE", length = 100)
    private String loginDevice;

    @Type( type = "com.kalem.enums.ECommerceUserTypeValue" )
    @Column( name = "TYPE", columnDefinition = "smallint", length = 1 )
    private ECommerceUserType type;

    @Type( type = "com.kalem.enums.UserTypeValue" )
    @Column( name = "USER_TYPE", columnDefinition = "smallint", length = 1 )
    private UserType userType;

    @Column(name = "MOBILE_PRINT_PATH_PALLET", length = 100)
    private String mobilePrintPathPallet;

    @Column(name = "MOBILE_PRINT_PATH_BARCODE", length = 100)
    private String mobilePrintPathBarcode;

    @Column(name = "MOBILE_PRINT_PATH_DELIVERY", length = 100)
    private String mobilePrintPathDelivery;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @Where(clause = "deleted <> 1")
    private Collection<UserRoleEntity> roles;



    @Override
    public UserEntity clone() throws CloneNotSupportedException {
        UserEntity entity = new UserEntity();
        entity.setID(this.getID());
        entity.setFullName(this.getFullName());
        entity.setEmail(this.getEmail());
        entity.setPassword(this.getPassword());
        entity.setPasswordExpired(this.getPasswordExpired());
        entity.setUsername(this.getUsername());
        entity.setRoles(this.getRoles());
        entity.setLoginTry(this.getLoginTry());
        entity.setLocalization(this.getLocalization());
        super.clone(entity);
        return entity;
    }

    // created and modified user causes stack over flow, this is the safe method not calling super clone
    public UserEntity cloneSafe() throws CloneNotSupportedException {
        UserEntity entity = new UserEntity();
        entity.setID(this.getID());
        entity.setCreatedDate(this.getCreatedDate());
        entity.setModifiedDate(this.getModifiedDate());
        entity.setDeleted(this.getDeleted());
        entity.setFullName(this.getFullName());
        entity.setEmail(this.getEmail());
        entity.setPassword(this.getPassword());
        entity.setPasswordExpired(this.getPasswordExpired());
        entity.setUsername(this.getUsername());
        entity.setRoles(this.getRoles());
        entity.setLoginTry(this.getLoginTry());
        entity.setLocalization(this.getLocalization());
        return entity;
    }

}
