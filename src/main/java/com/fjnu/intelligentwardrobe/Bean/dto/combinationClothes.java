package com.fjnu.intelligentwardrobe.Bean.dto;

import com.fjnu.intelligentwardrobe.Bean.clothes;

import java.util.List;

public class combinationClothes {

    private Integer combinationid;
    private String c_desc;
    private String occasion;
    private List<clothes> clothesList;

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getC_desc() {
        return c_desc;
    }

    public void setC_desc(String c_desc) {
        this.c_desc = c_desc;
    }

    public Integer getCombinationid() {
        return combinationid;
    }

    public void setCombinationid(Integer combinationid) {
        this.combinationid = combinationid;
    }

    public List<clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<clothes> clothesList) {
        this.clothesList = clothesList;
    }

    @Override
    public String toString() {
        return "combinationClothes{" +
                "combinationid=" + combinationid +
                ", c_desc='" + c_desc + '\'' +
                ", clothesList=" + clothesList +
                '}';
    }
}
