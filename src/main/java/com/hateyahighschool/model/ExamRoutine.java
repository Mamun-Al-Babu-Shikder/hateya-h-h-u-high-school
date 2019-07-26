package com.hateyahighschool.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by A.A.MAMUN on 7/14/2019.
 */
@Entity
public class ExamRoutine {

    @Id
    @SequenceGenerator(name="ExamRoutineSequence", sequenceName="ExamRoutineSequence",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ExamRoutineSequence")
    private Integer id;
    private String date;
    private String subject;
    private String startTime;
    private String endTime;
    @Column(length = 3)
    private Integer forClass;

    public ExamRoutine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getForClass() {
        return forClass;
    }

    public void setForClass(Integer forClass) {
        this.forClass = forClass;
    }
}
