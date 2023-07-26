package com.kalem.authenticationserver.basemodels.rest;

import com.kalem.sharedclass.basemodels.DefinitionDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class DescriptionDto extends DefinitionDto<Integer> {

    public DescriptionDto() {
    }

    public DescriptionDto(String code, String desc) {
        this.setCode(code);
        this.setDescription(desc);
    }


}
