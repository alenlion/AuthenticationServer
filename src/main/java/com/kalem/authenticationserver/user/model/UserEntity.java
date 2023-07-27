package com.kalem.authenticationserver.user.model;

import com.kalem.authenticationserver.baseclass.enums.LocalizationType;
import com.kalem.authenticationserver.baseclass.enums.UserStatusType;
import com.kalem.authenticationserver.baseclass.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;


@Data
@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "USERS",
        indexes = {
                @Index(name = "USERS_I1", columnList = "DELETED"),
                @Index(name = "USERS_I2", columnList = "DELETED,STATUS,USERNAME")
        })

public class UserEntity extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PASSWRD", nullable = false, length = 250)
    private String password;

    @Column(name = "USERNAME", nullable = false, length = 50)
    private String username;

    @Column(name = "FULL_NAME", nullable = false, length = 100)
    private String fullName;

    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column( name = "STATUS", columnDefinition = "smallint", nullable = false, length = 1 )
    private UserStatusType status;

    @Column(name = "PASSWRD_EXPIRED", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordExpired;

    @Enumerated(EnumType.STRING)
    @Column(name = "LANG_TYPE", nullable = false, length = 5)
    private LocalizationType localization = LocalizationType.tr_TR;

    @Column(name = "LOGIN_DEVICE", length = 100)
    private String loginDevice;

    @Column(name = "FULL_NAME", nullable = false, length = 50)
    private String firstname;

    @Column(name = "FULL_NAME", nullable = false, length = 50)
    private String lastname;

    @Column(name = "PHONE", nullable = false, length = 50)
    private String phone;

    //    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
//    @Where(clause = "deleted <> 1")
//    private Collection<UserRoleEntity> roles;

}
