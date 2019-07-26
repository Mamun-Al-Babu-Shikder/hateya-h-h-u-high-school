package com.hateyahighschool.controller;

import com.hateyahighschool.model.AppUser;
import com.hateyahighschool.model.BookReference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.A.MAMUN on 7/5/2019.
 */

@RestController
public class CpanelRestController {


    @RequestMapping(value = "/data", method = RequestMethod.POST)
    private void getDataFromJquery(@RequestBody AppUser appUser)
    {
        //System.out.println("Name : "+name+", City : "+city);
        System.out.println("Email : "+appUser.getEmail()+", Pass : "+appUser.getPassword());
    }

    @RequestMapping(value = "/data2", method = RequestMethod.GET)
    private List<String> getDataFromJquery2()
    {
        List<String> list = new ArrayList<>();
        list.add("Abc");
        list.add("Mamun");
        list.add("Mitu");

        return list;
    }



    @RequestMapping(value = "access_class", method = RequestMethod.GET)
    private List<BookReference> getBookList(@RequestParam int cls)
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        List<BookReference> bookList = null;
        try {
            bookList = session.createQuery("from BookReference where forClass=" + cls + "  order by id asc", BookReference.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sf.close();
        }

        System.out.println(bookList.toString());
        return bookList;
    }

    @RequestMapping(value = "save_book", method = RequestMethod.POST)
    private boolean saveBook(@RequestParam String bookName, @RequestParam String pdfLink, @RequestParam int forClass){

        System.out.println("----------------------------------------------- save book --------------------------------------------");

        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        try{

            Transaction t = session.beginTransaction();
            BookReference book = new BookReference();
            book.setBookName(bookName);
            book.setPdfFileLink(pdfLink);
            book.setForClass(forClass);

            System.out.println("Book : "+book.toString());

            session.save(book);
            t.commit();

            return true;

        }catch (Exception ex){
            System.out.println("Ex : \n"+ex.getMessage());
            return false;
        }finally {
            session.close();
            sf.close();
        }

    }



}
