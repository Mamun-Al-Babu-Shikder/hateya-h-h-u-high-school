package com.hateyahighschool.controller;

import com.hateyahighschool.model.Student;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.A.MAMUN on 4/14/2019.
 */
@Controller
public class Controller2 {


    private static List<Student> studentsList = new ArrayList<Student>();

    public Controller2()
    {

        System.out.println("Called -> Controller2()");

        studentsList.add(new Student(0,"Mitu Akter","hateya, Tangail"));
        studentsList.add(new Student(1,"Halima Khatun","Shamoli, Tangail"));
        studentsList.add(new Student(2,"Somit Mirza","Hatiya, Tangail"));
        studentsList.add(new Student(3,"Jannat Khatun","Mirpur, Dhaka"));
        studentsList.add(new Student(4,"Shakil Ahamed","Dhamri, Dhaka"));
        studentsList.add(new Student(5,"Lal mia","Thana Para, Tangail"));
    }


    @RequestMapping(value = "/display")
    public String disPlayStudent(ModelMap modelMap)
    {
        modelMap.addAttribute("students",studentsList);

        return "display_student";
    }


    @RequestMapping(value = "/delete/{id}")
    private String deleteStudent(@PathVariable(name = "id") int id){

        System.out.println("Student_Id : "+id);

        delete(id);

        return "redirect:/display";
    }

    @RequestMapping(value = "delete2")
    private String deleteStudent2(@RequestParam int id)
    {
        System.out.println("Student_Id : "+id);
        //Student stu =  studentsList.get(id);

        //System.out.println(stu.toString());
        //studentsList.remove(id);

        return "redirect:/display";
    }


    private void delete(int id){

        for(Student student : studentsList){
            if(student.getId()==id){
                studentsList.remove(student);
                break;
            }
        }
    }
}
