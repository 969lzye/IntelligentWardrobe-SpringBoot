package com.fjnu.intelligentwardrobe.Service.impl;

import com.fjnu.intelligentwardrobe.Bean.clothes;
import com.fjnu.intelligentwardrobe.Mapper.ClothesMapper;
import com.fjnu.intelligentwardrobe.Service.ClothesService;
import com.fjnu.intelligentwardrobe.Utils.SrcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClothesServiceImpl implements ClothesService {
    @Autowired
    private ClothesMapper clothesMapper;
    @Override
    public List<clothes> findClothesByTypeId(Integer uid,Integer typeid) {
        return clothesMapper.findClothesByTypeId(uid,typeid);
    }

    @Override
    public Boolean addClothes(Integer uid, String desc, Integer typeid, String imgsrc, String season, String occasion) {
        if (clothesMapper.addClothes(uid,desc,typeid,imgsrc,season,occasion)>0)
            return true;
        else
            return false;
    }

    @Override
    public List<clothes> findClothesByClothesId(Integer clothesid) {
        return clothesMapper.findClothesByClothesId(clothesid);
    }

    @Override
    public Boolean updateClothesByClothesid(Integer uid, String c_desc, Integer typeid, String imgsrc, String season, String occasion, Integer clothesid) {
        if (clothesMapper.updateClothes(uid,c_desc,typeid,imgsrc,season,occasion,clothesid)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean deleteClothes(Integer clothesid) {
        if (clothesMapper.deleteClothes(clothesid)>0)
            return true;
        else
            return false;
    }

    @Override
    public Integer deleteClothesByTypeid(Integer typeid) {
        return clothesMapper.deleteClothes(typeid);
    }

    @Override
    public List<clothes> findDirtyClothers(Integer uid) {
        return clothesMapper.findDirtyClothers(uid);
    }

    @Override
    public Integer updateClothesStatus(Integer clothesid, String status) {
        return clothesMapper.updateClothesStatus(clothesid,status);
    }
}
