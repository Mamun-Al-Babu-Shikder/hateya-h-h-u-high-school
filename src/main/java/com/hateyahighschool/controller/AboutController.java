package com.hateyahighschool.controller;

import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by A.A.MAMUN on 7/13/2019.
 */


@Controller
public class AboutController {

    @RequestMapping(value = "/about")
    private String init(ModelMap modelMap) {
        return "about";
    }



}
