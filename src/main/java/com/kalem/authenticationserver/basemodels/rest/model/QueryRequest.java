package com.kalem.authenticationserver.basemodels.rest.model;

import com.kalem.sharedclass.basemodels.CoreDto;
import com.kalem.sharedclass.commonmodels.masterapp.master.util.models.rest.ParameterDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedList;

@Getter
@Setter
public class QueryRequest<T extends CoreDto> extends CoreDto {

    private Query query = new Query();

    private Collection<ParameterDto> parameters = new LinkedList();

    private T filter;

}
