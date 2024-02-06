package com.example.trainingcore.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "mail.resources")
public class MailResourcesProperties {

    private String activationLink;
    private String restoreLink;
    private String mainLink;
    private String mainDomainName;

}
