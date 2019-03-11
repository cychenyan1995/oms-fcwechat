package com.glsx.oms.fcwechat.biz.wechat.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glsx.oms.fcwechat.biz.wechat.user.mapper.UserMapper;
import com.glsx.oms.fcwechat.biz.wechat.user.model.User;

/**
 * 微信用户表 Service
 */
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public List<User> getAll(){
        /*if (city.getPage() != null && city.getRows() != null) {
            PageHelper.startPage(city.getPage(), city.getRows());
        }*/
        return userMapper.selectAll();
    }

    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    
    public User getUser(User user) {
        return userMapper.selectOne(user);
    }
    
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int save(User user) {
        return userMapper.insert(user);
    }
    
    public void updateUserStatus(User user){
        userMapper.updateUserStatus(user);
    }
   
}