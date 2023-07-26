package com.kalem.authenticationserver.basemodels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kalem.basemodels.user.UserDto;
import com.kalem.basemodels.user.UserIDto;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlTransient;

@Getter
@Setter
@MappedSuperclass
public abstract class CreatedByDto<I extends Number> extends IDDto<I> {




}
