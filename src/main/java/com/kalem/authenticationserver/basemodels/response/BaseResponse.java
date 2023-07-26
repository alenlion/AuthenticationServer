package com.kalem.authenticationserver.basemodels.response;

import com.kalem.sharedclass.basemodels.CoreDto;
import com.kalem.sharedclass.basemodels.IOMessage;
import com.kalem.sharedclass.basemodels.UIMessage;
import com.kalem.sharedclass.enums.OutcomeType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedList;

@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseResponse extends CoreDto {

    OutcomeType outcomeType = OutcomeType.success;
    Collection<UIMessage> uiMessage = null;
    Collection<IOMessage> ioMessage = null;
    int status;
    // Artifact's name from the pom.xml file
    String name;

    // Artifact version
    String version;
    // Date and Time of the build
    String buildTime;

    public void setOutcome( OutcomeType type, String text ) {
        setOutcomeType( type );
        UIMessage ui = new UIMessage();
        ui.setText( text );
        getUIMessage().add( ui );
    }

    public Collection<UIMessage> getUIMessage() {
        if ( uiMessage == null )
            uiMessage = new LinkedList<>();

        return uiMessage;
    }

    public Collection<IOMessage> getIOMessage() {
        if ( ioMessage == null )
            ioMessage = new LinkedList<>();

        return ioMessage;
    }
}
