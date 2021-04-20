package com.fjnu.intelligentwardrobe.Service;

import com.fjnu.intelligentwardrobe.Bean.clothes;

import java.util.List;

public interface ClothesService {
    List<clothes> findClothesByTypeId(Integer uid,Integer typeid);
    Boolean addClothes(Integer uid,String desc,Integer typeid,String imgsrc,String season,String occasion);
    List<clothes> findClothesByClothesId(Integer clothesid);
    Boolean updateClothesByClothesid(Integer uid,String c_desc,Integer typeid,String imgsrc,String season,String occasion,Integer clothesid);
    Boolean deleteClothes(Integer clothesid);
    Integer deleteClothesByTypeid(Integer typeid);
    List<clothes> findDirtyClothers(Integer uid);
    Integer updateClothesStatus(Integer clothesid,String status);
}
