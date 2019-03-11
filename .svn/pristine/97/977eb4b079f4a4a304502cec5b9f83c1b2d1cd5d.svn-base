
package com.glsx.oms.fcwechat.biz.wechat.user.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glsx.oms.fcwechat.biz.wechat.user.model.User;
import com.glsx.oms.fcwechat.biz.wechat.user.service.UserService;

import org.oreframework.web.ui.Pagination;
import org.oreframework.web.ui.ResponseEntity;
import org.oreframework.web.ui.ResultEntity;
import org.oreframework.web.ui.ResultCode;


/**
 * 微信用户表 Controller
 */
@Scope("prototype")
@RestController
@RequestMapping(value = "/wechat")
public class UserController{
    
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResultEntity<User> get(@PathVariable("id") Integer id) {
        ResultEntity<User> resultEntity = new ResultEntity<User>();
        resultEntity.setData(userService.getById(id));
        resultEntity.setReturnCode(ResultCode.SUCCESS);
        resultEntity.setMessage("获取成功!");
        return resultEntity;
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResultEntity<User> delete(@PathVariable("id") Integer id) {
        ResultEntity<User> resultEntity = new ResultEntity<User>();
        userService.deleteById(id);
        resultEntity.setReturnCode(ResultCode.SUCCESS);
        resultEntity.setMessage("删除成功!");
        LOGGER.info("delete user id{}",id);
        return resultEntity;
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultEntity<User> save(@RequestBody User user) {
        ResultEntity<User> resultEntity = new ResultEntity<User>();
        userService.save(user);
        resultEntity.setReturnCode(ResultCode.SUCCESS);
        resultEntity.setMessage("保存成功!");
        return resultEntity;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getAll(Pagination pagination) {
        PageHelper.startPage(pagination.getCurrentPage(), pagination.getPageSize());
        List<User> userList = userService.getAll();
        
        ResponseEntity<User> responseObject = new ResponseEntity<User>();
        long total = ((Page<User>)userList).getTotal();
        responseObject.setData(userList);
        responseObject.setRecordsTotal(total);
        responseObject.setRecordsFiltered(total);
        return responseObject;
    }
    
   


    
    
}