package com.kalem.authenticationserver.basemodels.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kalem.basemodels.CreatedByWithStatusDto;
import com.kalem.jsonserializer.JsonSerializerIDescription;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddressDto extends CreatedByWithStatusDto<Integer> {

    @JsonSerialize(using = JsonSerializerIDescription.class)
    private UserDto user;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String addressLine4;

    private String city;

    private String region;

    private String postalCode;

    private Double longitude;

    private Double latitude;

}
