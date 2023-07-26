package com.kalem.authenticationserver.basemodels.rest.model;

import com.kalem.sharedclass.basemodels.CoreDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuerySort extends CoreDto {

    private String name;
    private boolean asc;

    public QuerySort() {
    }

    public QuerySort(String name, boolean asc) {
        this.name = name;
        this.asc = asc;
    }
}
