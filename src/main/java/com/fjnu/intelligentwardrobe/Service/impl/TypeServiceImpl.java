package com.fjnu.intelligentwardrobe.Service.impl;

import com.fjnu.intelligentwardrobe.Bean.type;
import com.fjnu.intelligentwardrobe.Mapper.TypeMapper;
import com.fjnu.intelligentwardrobe.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<type> getAllTypeByUid(Integer uid) {
        return typeMapper.getAllTypeByUid(uid);
    }

    @Override
    public Boolean saveType(Integer uid, String t_desc, String imgsrc) {
        if (typeMapper.saveType(uid,t_desc,imgsrc)>0)
            return true;
        else
            return false;
    }

    @Override
    public type findTypeByTypeid(Integer typeid) {
        return typeMapper.findTypeByTypeid(typeid);
    }

    @Override
    public Integer updateType(Integer typeid, String t_desc, String imgsrc) {
        return typeMapper.updateType(typeid,t_desc,imgsrc);
    }

    @Override
    public Integer deleteType(Integer typeid) {
        return typeMapper.deleteType(typeid);
    }
}
