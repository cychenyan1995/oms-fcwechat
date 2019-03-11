package com.glsx.oms.fcwechat.biz.flowcard.rop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glsx.oms.fcwechat.biz.flowcard.rop.request.ExampleRequest;
import com.glsx.oms.fcwechat.biz.flowcard.rop.response.ExampleResponse;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;

/**
 * 接口例子Controller
 */
@ServiceMethodBean(version = "1.0.0", needInSession = NeedInSessionType.NO)
public class ExampleController
{
    
    /**
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
     * 接口例子
     * 
     * @param req ExampleRequest
     * @return Object
     * @throws Exception 异常
     */
    
    @ServiceMethod(method = "org.ore.api.example", needInSession = NeedInSessionType.NO)
    public Object getExample(ExampleRequest req)
        throws Exception
    {
        ExampleResponse response = new ExampleResponse();
        response.setField1("Huang");
        response.setField2("Hellow!");
        return response;
    }
}
