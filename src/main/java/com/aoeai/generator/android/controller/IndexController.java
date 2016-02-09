package com.aoeai.generator.android.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "index";
    }

}
