package com.aoeai.generator.android.service;

import com.aoeai.generator.android.bean.Field;
import com.aoeai.generator.android.utils.AoeaiTools;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析服务
 * @author aoe
 * @date 2016/3/27
 * @tags
 */
@Service
public class ParseService implements IParseService{

    public List<Field> parseXml(String xml) throws DocumentException, UnsupportedEncodingException {
        List<Field> fieldList = new ArrayList<Field>();
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        Element root = doc.getRootElement(); // 根节点

        System.out.println("根节点："+root.getName()+",内容：" + root.attributeValue("id"));
        Field field = getField(root);
        if(field != null){
            fieldList.add(field);
        }

        // 递归添加子节点
        getElement(root, fieldList);

        return fieldList;
    }

    private void getElement(Element element, List<Field> fieldList){
        List list = element.elements();
        //递归方法
        for (Object aList : list) {
            Element chileEle = (Element) aList;
            System.out.println("节点：" + chileEle.getName() + ",内容：" + chileEle.attributeValue("id"));

            Field field = getField(chileEle);
            if(field != null){
                fieldList.add(field);
            }

            getElement(chileEle, fieldList);
        }
    }

    private Field getField(Element element){
        String original = element.attributeValue("id");
        if(AoeaiTools.isNotBlank(original)){
            Field field = new Field();
            field.setType(getType(element.getName()));
            field.setOriginal(original.replace("@+id/", ""));

            return field;
        }

        return null;
    }

    /**
     * 获得类名
     * @param type
     * @return
     */
    private String getType(String type){
        type = AoeaiTools.isBlank(type) ? "" : type;

        if(type.contains(".")){
            String[] arr = type.split("\\.");
            type = arr[arr.length - 1]; // 只取最后一个类名
        }

        return type;
    }
}
