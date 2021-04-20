package com.fjnu.intelligentwardrobe.Mapper;

import com.fjnu.intelligentwardrobe.Bean.type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    List<type> getAllTypeByUid(Integer uid);
    Integer saveType(Integer uid,String t_desc,String imgsrc);
    type findTypeByTypeid(Integer typeid);
    Integer updateType(Integer typeid,String t_desc,String imgsrc);
    Integer deleteType(Integer typeid);
}
