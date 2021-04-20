package com.fjnu.intelligentwardrobe.Service;

import com.fjnu.intelligentwardrobe.Bean.type;

import java.util.List;

public interface TypeService {
    List<type> getAllTypeByUid(Integer uid);
    Boolean saveType(Integer uid,String t_desc,String imgsrc);
    type findTypeByTypeid(Integer typeid);
    Integer updateType(Integer typeid,String t_desc,String imgsrc);
    Integer deleteType(Integer typeid);
}
