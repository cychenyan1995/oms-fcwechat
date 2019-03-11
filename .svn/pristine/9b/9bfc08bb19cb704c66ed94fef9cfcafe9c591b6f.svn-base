package com.glsx.oms.fcwechat.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageInfo;
import com.glsx.oms.fcwechat.biz.wechat.user.model.User;


/**
 * 微信用户表 调用REST资源
 */
@Component
public class UserClient
{
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${test.path}")
    private String url;
    
    public User get(Integer id)
    {
        User user = restTemplate.getForEntity(url + "/wechat/user/" + id, User.class).getBody();
        return user;
    }
    
    public Integer delete(Integer id)
    {
        restTemplate.delete(url + "/wechat/user/"+id);
        return id;
    }
    
    public User save(User flowCard)
    {
        return restTemplate.postForObject(url + "/wechat/user", flowCard, User.class);
    }
    
    public PageInfo<?> getAll()
    {
        return restTemplate.getForEntity(url + "/wechat/user", PageInfo.class).getBody();
    }
    

    
}