package com.glsx.oms.fcwechat.biz.flowcard.util;

import java.util.Random;

public class RandomUtil
{
    
    /*
     * 生成随机数
     */
    public static String createNonceStr()
    {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++)
        {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }
}
