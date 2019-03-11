package com.glsx.oms.fcwechat;

import java.net.URL;

import org.oreframework.boot.main.AbsOreBootStarter;
import org.oreframework.commons.beanutils.properties.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.glsx.oms.fcwechat.framework.config.WxToolsProperties;

@SpringBootApplication
@ServletComponentScan
public class OMSBootStarter extends AbsOreBootStarter
{
    private final static Logger logger = LoggerFactory.getLogger(OMSBootStarter.class);
    
    @Autowired
    private WxToolsProperties wxToolsProperties;
    
    
    
    @Bean
    public WxToolsProperties wxConfig()
    {
        
        URL url = OMSBootStarter.class.getResource("/wx.properties");
        if (null == url)
        {
            logger.info("****[ wx.properties ]**** file not existence!");
        }
        else
        {
            String fileName = url.getPath();
            PropertiesUtil propertiesUtil = new PropertiesUtil(fileName);
            propertiesUtil.writeProperties("wx.appId", wxToolsProperties.getAppId());
            propertiesUtil.writeProperties("wx.appSecret", wxToolsProperties.getAppSecret());
            propertiesUtil.writeProperties("wx.token", wxToolsProperties.getToken());
            propertiesUtil.writeProperties("wx.aesKey", wxToolsProperties.getAesKey());
        }
        
        return wxToolsProperties;
    }
    
    @Override
    public void run(String[] args)
    {
        SpringApplication.run(OMSBootStarter.class, args);
        
    }
    
    public static void main(String[] args)
    {
        OMSBootStarter starter = new OMSBootStarter();
        starter.run(args);
    }
    
}
