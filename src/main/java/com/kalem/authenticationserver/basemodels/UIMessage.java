package com.kalem.authenticationserver.basemodels;

import com.kalem.enums.MessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UIMessage extends Message {

    public UIMessage() {
        this.setType( MessageType.info );
    }
}
