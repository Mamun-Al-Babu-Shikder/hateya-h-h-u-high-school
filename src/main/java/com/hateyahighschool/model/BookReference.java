package com.hateyahighschool.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created by A.A.MAMUN on 7/13/2019.
 */
@Entity
public class BookReference {

    @Id
    @SequenceGenerator(name="BookReferenceSequence", sequenceName="BookReferenceSequence",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="BookReferenceSequence")
    private Integer id;
    @Column(length = 255)
    private String bookName;
    @Column(length = 255)
    private String pdfFileLink;
    @Column(length = 3)
    private Integer forClass;


    public BookReference() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPdfFileLink() {
        return pdfFileLink;
    }

    public void setPdfFileLink(String pdfFileLink) {
        this.pdfFileLink = pdfFileLink;
    }

    public Integer getForClass() {
        return forClass;
    }

    public void setForClass(Integer forClass) {
        this.forClass = forClass;
    }

    @Override
    public String toString() {
        return "BookReference{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", pdfFileLink='" + pdfFileLink + '\'' +
                ", forClass=" + forClass +
                '}';
    }
}
