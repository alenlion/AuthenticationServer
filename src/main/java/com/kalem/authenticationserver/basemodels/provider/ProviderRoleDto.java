package com.kalem.authenticationserver.basemodels.provider;import com.kalem.sharedclass.basemodels.CreatedByDto;import com.thoughtworks.xstream.annotations.XStreamAlias;import lombok.Data;@Data@SuppressWarnings( "serial" )@XStreamAlias( "provider_role" )public class ProviderRoleDto extends CreatedByDto<Integer> {    private String name;}