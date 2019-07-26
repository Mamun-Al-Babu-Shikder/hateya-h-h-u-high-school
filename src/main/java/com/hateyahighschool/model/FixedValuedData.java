package com.hateyahighschool.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by A.A.MAMUN on 7/18/2019.
 */
@Entity
public class FixedValuedData {


    @Id
    private String id;
    private String value;
    private String link;
    private String imgurl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "FixedValuedData{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", link='" + link + '\'' +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
