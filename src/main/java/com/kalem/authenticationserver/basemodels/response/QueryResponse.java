package com.kalem.authenticationserver.basemodels.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class QueryResponse<T extends Serializable> extends BaseQueryResponse {


    T data;
    byte[] zipData;
    private String version;
}
