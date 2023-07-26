package com.kalem.authenticationserver.basemodels.provider;

import com.kalem.sharedclass.basemodels.CreatedByDto;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@XStreamAlias("providerProviderRoles")
public class ProviderProviderRoleDto extends CreatedByDto<Integer> {

    private ProviderDto provider;

    private ProviderRoleDto role;

}
