package com.hateyahighschool.model;

import javax.persistence.*;

/**
 * Created by A.A.MAMUN on 7/14/2019.
 */
@Entity
public class ClassLecture {

    @Id
    @SequenceGenerator(name="ClassLectureSequence", sequenceName="ClassLectureSequence",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ClassLectureSequence")
    private Integer id;
    private String title;
    private String link;
    private Integer forClass;

    public ClassLecture() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getForClass() {
        return forClass;
    }

    public void setForClass(Integer forClass) {
        this.forClass = forClass;
    }
}
