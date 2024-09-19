package org.spring.cloud.example.controller;

import org.spring.cloud.example.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/v1")
public class DemoController {

    private PropertyConfig propertyConfig;

    @Autowired
    public DemoController(PropertyConfig propertyConfig) {
        this.propertyConfig = propertyConfig;
    }

    @GetMapping("/secret")
    public String liveReload() {
        return "Configmap Value: " + propertyConfig.getTestConfigmapProperty() +
                "\nSecret Value: " + propertyConfig.getTestSecretProperty() +
                "\nMounted Secret Value: " + propertyConfig.getTestMountedSecretProperty();
    }
}
