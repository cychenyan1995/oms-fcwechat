package com.glsx.oms.fcwechat.biz.flowcard.rop.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Example
 * 
 * @author  xiaowy
 * @version  [版本号, 2016-12-27]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "exampleResponse")
public class ExampleResponse
{
    
    @XmlAttribute
    private String field1 = "1";

    @XmlAttribute
    private String field2 = "2";
    

   public void setField1(String field1) {
       this.field1 = field1;
   }

   public String getField2() {
       return field2;
   }

   public void setField2(String field2) {
       this.field2 = field2;
   }
   
    /**
     * 得到属性字符串
     * 
     * @return String 属性字符串
     */
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
    
}