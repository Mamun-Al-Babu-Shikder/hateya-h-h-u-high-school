package com.hateyahighschool.controller;

import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by A.A.MAMUN on 6/23/2019.
 */

@Controller
public class HomeController {


    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }




}



