package org.spring.cloud.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "test-live-secrets-k8s")
public class PropertyConfig {
    private String testSecretProperty;
    private String testConfigmapProperty;
    private String testMountedSecretProperty;
}
