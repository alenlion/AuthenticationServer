package com.kalem.authenticationserver.basemodels.user;


import com.kalem.sharedclass.basemodels.IDDto;
import com.kalem.sharedclass.enums.ReminderStatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserPasswordVerifyDto extends IDDto<Integer> {

    private UserDto user;

    private Date requestTime;

    private Date responseTime;

    private String token;

    private ReminderStatusType status;

}
