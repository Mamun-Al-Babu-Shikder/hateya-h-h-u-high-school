package com.hateyahighschool.controller;

import com.hateyahighschool.dbconnection.DbConnection;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by A.A.MAMUN on 6/23/2019.
 */

@Controller
public class HomeController {


    @RequestMapping(value = "/")
    public String home(Model model){

        DbConnection dbc = new DbConnection();
        model.addAttribute("bol",dbc.getBol());
        model.addAttribute("ex",dbc.getEx());
        return "home";
    }




}



