package com.aoeai.generator.android.service;

import com.aoeai.generator.android.bean.Field;
import org.dom4j.DocumentException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 解析服务
 * @author aoe
 * @date 2016/3/27
 * @tags
 */
public interface IParseService {

    /**
     * 解析xml文件
     * @param xml Android的xml文件内容
     * @return 包含解析数据的列表
     * @throws DocumentException
     * @throws UnsupportedEncodingException
     */
    List<Field> parseXml(String xml) throws DocumentException, UnsupportedEncodingException;
}
