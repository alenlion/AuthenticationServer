package com.kalem.authenticationserver.basemodels.rest.model;


import com.kalem.sharedclass.basemodels.CoreDto;
import com.kalem.sharedclass.enums.FetchType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QueryPaging extends CoreDto {

    private int offset;
    private int limit;
    private long total;
    private FetchType fetch = FetchType.LAZY;
}
