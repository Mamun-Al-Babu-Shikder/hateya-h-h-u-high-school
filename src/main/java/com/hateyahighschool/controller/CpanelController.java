package com.hateyahighschool.controller;

import com.hateyahighschool.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

           AppUser appUser = session.createQuery("FROM AppUser WHERE email='"+email+"'",AppUser.class).getSingleResult();
            if (appUser != null) {
                System.out.println("AppUser : "+appUser.toString());
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
            //System.out.println("Exception:-------------------------------------------------------------\n");
            //ex.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
            sessionFactory.close();
        }

        return "login";
    }



    @RequestMapping(value ="/class", method = RequestMethod.POST)
    private String getClassAccess(HttpServletRequest request, @RequestParam String select_class, ModelMap modelMap)
    {

        HttpSession session = request.getSession();
        if(session.getAttribute("login_email")==null){
            return "redirect:/login_page";
        }else{

            System.out.println("-------------------------\n"+select_class+"\n------------------------");

            if(select_class.equalsIgnoreCase("Access Class - 06")) {
                modelMap.addAttribute("access_class",6);
                getDataModelOrderByClass(modelMap, 6);
            }else if(select_class.equalsIgnoreCase("Access Class - 07")) {
                modelMap.addAttribute("access_class",7);
                getDataModelOrderByClass(modelMap, 7);
            }else if(select_class.equalsIgnoreCase("Access Class - 08")) {
                modelMap.addAttribute("access_class",8);
                getDataModelOrderByClass(modelMap, 8);
            }else if(select_class.equalsIgnoreCase("Access Class - 09")) {
                modelMap.addAttribute("access_class",9);
                getDataModelOrderByClass(modelMap, 9);
            }else if(select_class.equalsIgnoreCase("Access Class - 10")) {
                modelMap.addAttribute("access_class",10);
                getDataModelOrderByClass(modelMap, 10);
            }

            return "cpanel_class";
        }

    }


    @RequestMapping(value = "/access_class-data")
    private String getClassSixAccess(HttpServletRequest request, ModelMap modelMap)
    {
        /*
        HttpSession session = request.getSession();
        if(session.getAttribute("login_email")==null){
            return "redirect:/login_page";
        }else{



            //modelMap.addAttribute("access_class",6);
            //getDataModelOrderByClass(modelMap, 6);



            return "cpanel_class";
        }
        */

        return "cpanel_class";
    }



    private void getDataModelOrderByClass(ModelMap modelMap ,int _class){

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
       // Transaction transaction = session.beginTransaction();

        try{

            List<BookReference> bookList = session.createQuery("from BookReference where forClass="+_class+"  order by id asc", BookReference.class).list();
            modelMap.addAttribute("bookList", bookList);

            List<ClassRoutine> classRoutinesList = session.createQuery("from ClassRoutine where forClass="+_class+" order by id asc", ClassRoutine.class).list();
            modelMap.addAttribute("classRoutinesList",classRoutinesList);

            List<ExamRoutine> examRoutineList = session.createQuery("from ExamRoutine where forClass="+_class+" order by id asc", ExamRoutine.class).list();
            modelMap.addAttribute("examRoutineList",examRoutineList);

            List<ClassLecture> classLecturesList = session.createQuery("from ClassLecture where forClass="+_class+" order by id desc",ClassLecture.class).list();
            modelMap.addAttribute("classLecturesList", classLecturesList);

            List<ExamResult> examResultList = session.createQuery("from ExamResult where forClass="+_class+" order by id desc", ExamResult.class).list();
            modelMap.addAttribute("examResultList",examResultList);

            FixedValuedData footer_social_media_facebook = session.get(FixedValuedData.class,"footer_social_media_facebook");
            modelMap.addAttribute("footer_social_media_facebook",footer_social_media_facebook.getLink());

            FixedValuedData footer_social_media_twitter = session.get(FixedValuedData.class,"footer_social_media_twitter");
            modelMap.addAttribute("footer_social_media_twitter",footer_social_media_twitter.getLink());

            FixedValuedData footer_social_media_linkedin = session.get(FixedValuedData.class,"footer_social_media_linkedin");
            modelMap.addAttribute("footer_social_media_linkedin",footer_social_media_linkedin.getLink());

            FixedValuedData footer_information_tel = session.get(FixedValuedData.class,"footer_information_tel");
            modelMap.addAttribute("footer_information_tel",footer_information_tel.getValue());

            FixedValuedData footer_information_email = session.get(FixedValuedData.class,"footer_information_email");
            modelMap.addAttribute("footer_information_email",footer_information_email.getValue());


            System.out.println("success");
            //System.out.println( session.get(FixedValuedData.class, "fotter_social media_facebook").toString());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            //transaction.commit();
            session.close();
            sessionFactory.close();
        }

        return ;
    }




    @RequestMapping(value = "/logout")
    private String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/cpanel";
    }





}
