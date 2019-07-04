package com.hateyahighschool.controller;

import com.hateyahighschool.model.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by A.A.MAMUN on 7/4/2019.
 */
@Controller
public class CpanelController {

    private Configuration configuration;
    private SessionFactory sessionFactory;
    private Session session;


    @RequestMapping(value = "/cpanel")
    private String openCpanel(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("login_email")==null){
            return "redirect:/login_page";
        }else{
            return "cpanel";
        }
    }


    @RequestMapping(value = "/login_page")
    private String loginPage(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String login(@RequestParam String email, @RequestParam String password, ModelMap modelMap, HttpServletRequest request){

        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

           AppUser appUser = session.createQuery("FROM AppUser",AppUser.class).getSingleResult();
            if (appUser != null) {
                if(appUser.getPassword().equals(password)){
                    request.getSession().setAttribute("login_email", email);
                    //request.getSession().setMaxInactiveInterval(request.getSession().getMaxInactiveInterval());
                    return "redirect:/cpanel";
                }else{
                    modelMap.put("login_error", "Email or password is wrong, please try again with another one.");
                }
            }
        }catch(Exception ex){
            modelMap.put("login_error", "Email or password is wrong, please try again with another one.");
            //ex.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
            sessionFactory.close();
        }

        return "login";
    }


    @RequestMapping(value = "/logout")
    private String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/cpanel";
    }





}
