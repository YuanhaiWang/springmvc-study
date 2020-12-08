package com.yuanhai.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把固定字符串格式转换为日期格式
 * @author yuanhai
 * @date 2020/12/8
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * source : 传进来的值
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        if(null == source){
            throw new RuntimeException("请传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // 把字符串转换成日期
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出错");
        }

    }
}
