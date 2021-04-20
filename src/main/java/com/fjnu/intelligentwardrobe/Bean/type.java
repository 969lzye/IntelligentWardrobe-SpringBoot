package com.fjnu.intelligentwardrobe.Bean;

import java.util.Date;

public class type {
    private Integer typeid;
    private Integer uid;
    private String t_desc;
    private String imgsrc;
    private Date time;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getT_desc() {
        return t_desc;
    }

    public void setT_desc(String t_desc) {
        this.t_desc = t_desc;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "type{" +
                "typeid=" + typeid +
                ", uid=" + uid +
                ", desc='" + t_desc + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", time=" + time +
                '}';
    }
}
