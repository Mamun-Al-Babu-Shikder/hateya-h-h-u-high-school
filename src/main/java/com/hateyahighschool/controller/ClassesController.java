package com.hateyahighschool.controller;

import com.hateyahighschool.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by A.A.MAMUN on 7/13/2019.
 *
 * Book Adding Query : INSERT INTO bookreference VALUES(id,'book_name',6,'pdf_link')
 * ClassRoutine Adding Query : INSERT INTO classroutine (id, day, one, two, three, four, five, six, forClass) VALUES (61,'SAT','Bangla','English','Math','Social','Religias','Bangla 2',6)
 * ExamRoutine Adding Query : INSERT INTO examroutine (id, date, subject, startTime, endTime, forClass) VALUES (1,'04/08/2019','Mathematics','02:00 PM','05:00 PM', 6)
 * FixedValuedData Adding Query : INSERT INTO fixedvalueddata (id, value, link, imgurl) VALUES ('fotter_social media','NaN','https://www.facebook.com', 'NaN')
 *
 *
 */


@Controller
public class ClassesController {


    @RequestMapping(value = "/class-6")
    private String classSixInit(ModelMap modelMap){
        modelMap.addAttribute("access_class",6);
        getDataModelOrderByClass(modelMap,6);
        return "classes";
    }

    @RequestMapping(value = "/class-7")
    private String classSevenInit(ModelMap modelMap){
        modelMap.addAttribute("access_class",7);
         getDataModelOrderByClass(modelMap,7);
        return "classes";
    }

    @RequestMapping(value = "/class-8")
    private String classEightInit(ModelMap modelMap){
        modelMap.addAttribute("access_class",8);
        getDataModelOrderByClass(modelMap,8);
        return "classes";
    }

    @RequestMapping(value = "/class-9")
    private String classNineInit(ModelMap modelMap){
        modelMap.addAttribute("access_class",9);
        getDataModelOrderByClass(modelMap,9);
        return "classes";
    }

    @RequestMapping(value = "/class-10")
    private String classTenInit(ModelMap modelMap){
        modelMap.addAttribute("access_class",10);
        getDataModelOrderByClass(modelMap,10);
        return "classes";
    }


    public void getDataModelOrderByClass(ModelMap modelMap ,int _class){


        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


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


           // System.out.println( session.get(FixedValuedData.class, "fotter_social media_facebook").toString());



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            transaction.commit();
            session.close();
            sessionFactory.close();
        }

        return ;
    }



}
