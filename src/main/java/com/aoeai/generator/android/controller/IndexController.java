package com.aoeai.generator.android.controller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
public class IndexController {

    /*@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }*/

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/createAndroidCode")
    public String createAndroidCode(String xmlCode, Model model) {
        model.addAttribute("name", xmlCode);

        try {
            try {
                parseXml(xmlCode);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return "index";
    }


    private void parseXml(String xml) throws DocumentException, UnsupportedEncodingException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        Element root = doc.getRootElement();
        System.out.println("根节点："+root.getName()+",内容："+root.attributeValue("id"));

        getElement(root);
    }

    private static void getElement(Element element){
        List list = element.elements();
        //递归方法
        for (Object aList : list) {
            Element chileEle = (Element) aList;
            System.out.println("节点：" + chileEle.getName() + ",内容：" + chileEle.attributeValue("id"));
            getElement(chileEle);
        }
    }
}

