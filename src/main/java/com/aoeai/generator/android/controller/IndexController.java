package com.aoeai.generator.android.controller;

import com.aoeai.generator.android.bean.Field;
import com.aoeai.generator.android.service.IParseService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
public class IndexController {

    /*@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }*/

    @Autowired
    private IParseService iParseService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/createAndroidCode")
    public String createAndroidCode(String xmlCode, Model model) {
        model.addAttribute("xmlCode", xmlCode);

        try {
            List<Field> fieldList = iParseService.parseXml(xmlCode);
            model.addAttribute("fieldList", fieldList);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "index";
    }


}

