package com.fjnu.intelligentwardrobe.Bean.dto;

import com.fjnu.intelligentwardrobe.Bean.clothes;

import java.util.List;

public class ClothesListDto {

    List<clothes> clist;

    public List<clothes> getClist() {
        return clist;
    }

    public void setClist(List<clothes> clist) {
        this.clist = clist;
    }
}
