package com.aoeai.generator.android.controller;

import com.aoeai.generator.android.bean.Field;
import com.aoeai.generator.android.service.IParseService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/createAndroidCode", method = RequestMethod.GET)
    public String createAndroidCode() {
        return "index";
    }

    /**
     * 生成Android代码
     *
     * @param xmlCode   Android的xml内容
     * @param typeMerge 1 同类型合并-否; 2 同类型合并-是
     * @param model
     * @return
     */
    @RequestMapping(value = "/createAndroidCode", method = RequestMethod.POST)
    public String createAndroidCode(String xmlCode, int typeMerge, Model model) {
        model.addAttribute("xmlCode", xmlCode);
        model.addAttribute("typeMerge", typeMerge);

        try {
            List<Field> fieldList = iParseService.parseXml(xmlCode);
            model.addAttribute("fieldList", fieldList);
            if(typeMerge != 1){
                model.addAttribute("mergeFieldList", iParseService.getMergeTypeResult(fieldList));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "index";
    }


}

