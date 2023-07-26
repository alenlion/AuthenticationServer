package com.kalem.authenticationserver.basemodels.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kalem.sharedclass.basemodels.CreatedByDto;
import com.kalem.sharedclass.basemodels.RoleDto;
import com.kalem.sharedclass.enums.RecordStatusType;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlTransient;

@Getter
@Setter
@ToString
public class UserRoleDto extends CreatedByDto<Integer> {

    @XStreamOmitField
    @JsonIgnore
    @XmlTransient
    private UserDto user;

    private RoleDto role;

    private RecordStatusType recStatus;

}
