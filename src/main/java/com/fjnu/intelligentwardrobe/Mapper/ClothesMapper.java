package com.fjnu.intelligentwardrobe.Mapper;

import com.fjnu.intelligentwardrobe.Bean.clothes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ClothesMapper {
    List<clothes> findClothesByTypeId(Integer uid,Integer typeid);
    Integer addClothes(Integer uid,String desc,Integer typeid,String imgsrc,String season,String occasion);
    List<clothes> findClothesByClothesId(Integer clothesid);
    Integer updateClothes(Integer uid,String c_desc,Integer typeid,String imgsrc,String season,String occasion,Integer clothesid);
    Integer deleteClothes(Integer clothesid);
    Integer deleteClothesByTypeid(Integer typeid);
    List<clothes> findDirtyClothers(Integer uid);
    Integer updateClothesStatus(Integer clothesid,String status);
}
