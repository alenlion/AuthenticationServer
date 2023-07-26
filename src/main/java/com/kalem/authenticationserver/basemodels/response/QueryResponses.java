package com.kalem.authenticationserver.basemodels.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode
public class QueryResponses<T extends Serializable> extends BaseQueryResponse {

    Collection<T> data;
    byte[] zipData;


}
