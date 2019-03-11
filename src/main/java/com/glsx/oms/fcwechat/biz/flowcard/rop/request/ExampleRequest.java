package com.glsx.oms.fcwechat.biz.flowcard.rop.request;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.rop.AbstractRopRequest;

/**
 * 例子参数实体类
 * 
 * @author  xiaowy
 * @version  [版本号, 2016-12-23]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ExampleRequest extends AbstractRopRequest
{
    
    /**
     * 得到属性字符串
     * @return String 属性字符串
     */
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

}