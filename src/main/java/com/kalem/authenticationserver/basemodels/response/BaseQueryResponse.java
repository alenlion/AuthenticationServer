package com.kalem.authenticationserver.basemodels.response;


import com.kalem.sharedclass.basemodels.rest.model.Query;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseQueryResponse extends BaseResponse {

    Query query = new Query();

}
