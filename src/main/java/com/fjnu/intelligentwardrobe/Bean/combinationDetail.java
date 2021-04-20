package com.fjnu.intelligentwardrobe.Bean;

public class combinationDetail {
    private Integer combinationId;
    private Integer clothesId;

    public Integer getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Integer combinationId) {
        this.combinationId = combinationId;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    @Override
    public String toString() {
        return "combinationDetail{" +
                "combinationId=" + combinationId +
                ", clothesId=" + clothesId +
                '}';
    }
}
