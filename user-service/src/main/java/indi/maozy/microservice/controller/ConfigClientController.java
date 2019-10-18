package indi.maozy.microservice.controller;

import indi.maozy.microservice.config.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author 毛中勇
 * @create 2019-10-15 16:57
 */
@RestController
public class ConfigClientController {

    @Autowired
    private ConfigInfoProperties configInfoProperties;

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo() {
        return configInfoProperties.getConfig();
    }

}