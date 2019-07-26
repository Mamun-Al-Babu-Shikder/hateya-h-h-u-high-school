package com.hateyahighschool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by A.A.MAMUN on 7/13/2019.
 */
@Entity
public class ClassRoutine {


    @Id
    private Integer id;
    @Column(length = 3)
    private Integer forClass;
    @Column(length = 10)
    private String day;
    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String six;

    public ClassRoutine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getForClass() {
        return forClass;
    }

    public void setForClass(Integer forClass) {
        this.forClass = forClass;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }
}
