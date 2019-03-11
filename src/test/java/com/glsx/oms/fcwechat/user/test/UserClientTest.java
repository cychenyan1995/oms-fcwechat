package com.glsx.oms.fcwechat.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.glsx.oms.OMSTestBootStarter;
import com.glsx.oms.fcwechat.biz.wechat.user.model.User;
import com.glsx.oms.fcwechat.user.rest.UserClient;

/**
 * 微信用户表 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OMSTestBootStarter.class)
public class UserClientTest
{
    private final static Logger LOGGER = LoggerFactory.getLogger(UserClientTest.class);
    
    @Autowired
    private UserClient client;
    
    @Test
    public void testGet()
    {
        LOGGER.info("getWechauser = {} \n", client.get(9999999));
    }
    
    @Test
    public void testDelete()
    {
        LOGGER.info("deleteWechauser = {}", client.delete(9999999));
    }
    
    @Test
    public void testSave()
    {
        User user = new User();
        user.setId(9999999);
        user.setMerchantId("19180001");
        user.setWxNo("ore.framework.test");
        user.setStatus(0);
        LOGGER.info("saveWechauser = {}", client.save(user));
    }
    
    @Test
    public void testGetAll()
    {
        LOGGER.info("getAllWechauser = {}", client.getAll());
    }
    
}