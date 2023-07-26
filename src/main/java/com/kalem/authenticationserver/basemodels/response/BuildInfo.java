package com.kalem.authenticationserver.basemodels.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.info.BuildProperties;

/**
 * @author Mohammad Nobakht
 * @since 2.03.2022
 */
//@Component
@Getter
@Setter
public class BuildInfo {
    BuildProperties buildProperties;

    // Artifact's name from the pom.xml file
    String name;

    // Artifact version
    String version;
    // Date and Time of the build
    String buildTime;

    public BuildInfo( BuildProperties buildProperties ) {
        this.buildProperties = buildProperties;
        name = buildProperties.getName();
        // Artifact version
        version = buildProperties.getVersion();
        // Date and Time of the build
        buildTime = buildProperties.getTime().toString();

    }
}
