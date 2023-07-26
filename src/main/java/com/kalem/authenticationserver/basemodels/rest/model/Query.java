package com.kalem.authenticationserver.basemodels.rest.model;

import com.kalem.sharedclass.basemodels.CoreDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter

public class Query extends CoreDto {

    Collection<QuerySort> sort = null;

    QueryPaging paging = null;

}
