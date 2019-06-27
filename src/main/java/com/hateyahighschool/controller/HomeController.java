package com.hateyahighschool.controller;

import com.hateyahighschool.dbconnection.DbConnection;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * Created by A.A.MAMUN on 6/23/2019.
 */

@Controller
public class HomeController {

    public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static";

    @RequestMapping(value = "/")
    public String home(Model model){

        DbConnection dbc = new DbConnection();
        model.addAttribute("bol",dbc.getBol());
        model.addAttribute("ex",dbc.getEx());
        try {
            dbc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "home";
    }

    @RequestMapping(value = "/upload")
    public String uploadFile(@RequestParam MultipartFile file, Model model)
    {
        Path filePath = Paths.get(uploadDir, file.getOriginalFilename());
        try {
            Files.write(filePath, file.getBytes());
            model.addAttribute("file_ex",filePath.toAbsolutePath());
        } catch (IOException e) {
            model.addAttribute("file_ex",e);
            e.printStackTrace();
        }
        return "home";
    }








}



