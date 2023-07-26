package com.kalem.authenticationserver.basemodels;

import com.kalem.sharedclass.enums.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class Message implements Cloneable, Serializable {

    private MessageType type = MessageType.info;

    private String code;

    private String text;
}
