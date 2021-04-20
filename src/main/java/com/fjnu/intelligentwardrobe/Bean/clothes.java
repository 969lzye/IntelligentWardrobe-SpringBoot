package com.fjnu.intelligentwardrobe.Bean;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;

public class clothes {
    private Integer clothesid;
    private Integer uid;
    private String c_desc;
    private Integer typeid;
    private String imgsrc;
    private Boolean iscleaned;
    private String season;
    private String occasion;
    private Date time;

    public Integer getClothesid() {
        return clothesid;
    }

    public void setClothesid(Integer clothesid) {
        this.clothesid = clothesid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getC_desc() {
        return c_desc;
    }

    public void setC_desc(String c_desc) {
        this.c_desc = c_desc;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Boolean getIscleaned() {
        return iscleaned;
    }

    public void setIscleaned(Boolean iscleaned) {
        this.iscleaned = iscleaned;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "clothes{" +
                "clothesid=" + clothesid +
                ", uid=" + uid +
                ", c_desc='" + c_desc + '\'' +
                ", typeid=" + typeid +
                ", imgsrc='" + imgsrc + '\'' +
                ", iscleaned=" + iscleaned +
                ", season='" + season + '\'' +
                ", occasion='" + occasion + '\'' +
                ", time=" + time +
                '}';
    }
}
