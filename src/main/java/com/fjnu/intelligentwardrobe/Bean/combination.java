package com.fjnu.intelligentwardrobe.Bean;

import java.util.Date;

public class combination {
    private Integer combinationId;
    private Integer uid;
    private String c_desc;
    private Date time;

    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "combination{" +
                "combinationId=" + combinationId +
                ", uid=" + uid +
                ", c_desc='" + c_desc + '\'' +
                ", time=" + time +
                '}';
    }
}
