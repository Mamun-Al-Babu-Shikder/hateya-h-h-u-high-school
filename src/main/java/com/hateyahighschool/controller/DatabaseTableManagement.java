package com.hateyahighschool.controller;


import com.fasterxml.classmate.AnnotationConfiguration;
import com.hateyahighschool.model.Student;
import com.hateyahighschool.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by A.A.MAMUN on 6/24/2019.
 */

@Controller
public class DatabaseTableManagement {

    @RequestMapping(value = "open")
    public String open(ModelMap modelMap) {


        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");//.addAnnotatedClass(User.class);

            SessionFactory sf = configuration.buildSessionFactory();
            Session session = sf.openSession();

            System.out.println("SF : " + sf);
            System.out.println("Session : " + session);

            //User user = session.get(User.class, 1);
            //User user2 = session.get(User.class, 1);

        /*
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        */
            List<User> users = session.createQuery("FROM User ", User.class).list();


            modelMap.put("users", users);

            sf.close();
            session.close();

        }catch (Exception ex){
            modelMap.put("ex",ex);
            ex.printStackTrace();
        }

        return "display_user";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestParam String email, @RequestParam String pass, ModelMap modelMap)
    {
        try {

            User user = new User();
            user.setEmail(email);
            user.setPassword(pass);

            Configuration configuration = new Configuration().configure();//.addAnnotatedClass(User.class);
            SessionFactory sf = configuration.buildSessionFactory();
            Session session = sf.openSession();

            //System.out.println("SF : "+sf);
            //System.out.println("Session : "+session);

           // User u = session.get(User.class, 2);
           // System.out.println(u.toString());

            Transaction t =  session.beginTransaction();
            session.save(user);
            t.commit();

            session.close();
            sf.close();

        }catch (Exception ex){
            System.out.print("Ex : "+ex);
        }


        return "redirect:/open";
    }

    @RequestMapping(value = "/delete_user/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(name = "id") int id, ModelMap modelMap)
    {

        try {

            // System.out.println("Delete ID: "+id);

            Configuration configuration = new Configuration().configure();//.addAnnotatedClass(User.class);

            SessionFactory sf = configuration.buildSessionFactory();
            Session session = sf.openSession();


            Transaction t = session.beginTransaction();
            session.createSQLQuery("DELETE FROM user WHERE ID = " + id).executeUpdate();
            t.commit();


            // User user = session.get(User.class, 1);
            // User user2 = session.get(User.class, 1);

        /*
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        */
            //List<User> users = session.createQuery("FROM User ",User.class).list();


            //modelMap.put("users",users);

            sf.close();
            session.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }




        return "redirect:/open";
    }

}
