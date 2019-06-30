package com.hateyahighschool.controller;


import com.hateyahighschool.model.AppUser;
import com.hateyahighschool.model.Login;
import com.hateyahighschool.service.DatabaseService;
import org.springframework.http.HttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import java.sql.DriverManager;

@org.springframework.stereotype.Controller
public class Controller {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    DatabaseService databaseService;
    private String name;


    public Controller() {
        try{
            //databaseService = new DatabaseService();
            entityManager = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa")
                    .createEntityManager();
            entityTransaction = entityManager.getTransaction();
        }catch (Exception ex){
            System.out.println("Ex : => "+ex.toString());
        }
    }


    @RequestMapping(value = "/home")
    private String home(ModelMap modelMap){

        modelMap.addAttribute("file_ex","https://raw.githubusercontent.com/mjstest/orgb2/cecf78980616e67e2caedce74d22480c/images%20(1).png");
        modelMap.addAttribute("login", new Login("aalmamun","123456"));
        modelMap.put("val","mamun");

        return "home";
    }

    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public String login(ModelMap modelMap, @RequestParam String email, @RequestParam String password)
    {

        modelMap.addAttribute("val","Username : "+email+", Password : "+password);

        try{
            AppUser user = new AppUser();
            user.setEmail(email);
            user.setPassword(password);

           // DatabaseService service = new DatabaseService();

            //service.insertData(1,email,password);

            entityManager.getTransaction().begin();
            entityManager.persist(user);



            entityManager.getTransaction().commit();

        }catch (Exception ex){
            System.out.println("Ex : \n"+ex);
        }

        return "home";
    }


}
