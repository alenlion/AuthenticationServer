package com.kalem.authenticationserver.basemodels;

import com.kalem.enums.MessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Message extends CoreDto {

    private MessageType type = MessageType.info;

    private String code;

    private String text;
}
