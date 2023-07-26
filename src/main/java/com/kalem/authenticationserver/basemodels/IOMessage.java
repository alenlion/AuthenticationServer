package com.kalem.authenticationserver.basemodels;

import com.kalem.sharedclass.enums.MessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IOMessage extends Message {

    public IOMessage() {
        this.setType( MessageType.error );
    }
}
