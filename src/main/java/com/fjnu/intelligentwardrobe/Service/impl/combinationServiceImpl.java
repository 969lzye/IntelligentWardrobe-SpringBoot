package com.fjnu.intelligentwardrobe.Service.impl;

import com.fjnu.intelligentwardrobe.Bean.combination;
import com.fjnu.intelligentwardrobe.Bean.dto.combinationClothes;
import com.fjnu.intelligentwardrobe.Mapper.combinationMapper;
import com.fjnu.intelligentwardrobe.Service.combinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class combinationServiceImpl implements combinationService {
    @Autowired
    private combinationMapper combinationMapper;
    @Override
    public Integer addCombination( Integer uid, String c_desc,String occasion) {
        combinationMapper.addCombination(uid,c_desc,occasion);
        return combinationMapper.getLastInsertId();
    }

    @Override
    public Integer addClothesToCombination(Integer uid,Integer combinationId, Integer clothesId,Integer value) {
        return combinationMapper.addClothesToCombination(uid,combinationId,clothesId,value);
    }

    @Override
    public List<combinationClothes> findCombinationByUid(Integer uid) {
        return combinationMapper.findCombinationByUid(uid);
    }

    @Override
    public combinationClothes findCombinationBycombinationid(Integer combinationid) {
        return combinationMapper.findCombinationBycombinationid(combinationid);
    }

    @Override
    public Integer deleteCombination(Integer combinationid) {
        return combinationMapper.deleteCombination(combinationid);
    }

    @Override
    public Integer deleteCombinationDetailed(Integer combinationid) {
        return combinationMapper.deleteCombinationDetailed(combinationid);
    }

    @Override
    public Integer updateCombination(Integer combinationid, String c_desc,String occasion) {
        return combinationMapper.updateCombination(combinationid,c_desc,occasion);
    }

    @Override
    public List<combinationClothes> findRecommendCombination(Integer uid, String occasion) {
        return combinationMapper.findRecommendCombination(uid,occasion);
    }

    @Override
    public Integer addRecommendCombination(Integer uid, String c_desc, String occasion) {
        combinationMapper.addRecommendCombination(uid,c_desc,occasion);
        return combinationMapper.getLastInsertId();
    }

    @Override
    public Integer addClothesToRecommendCoombination(Integer uid, Integer combinationId, Integer clothesId, Integer value) {
        return combinationMapper.addClothesToRecommendCoombination(uid,combinationId,clothesId,value);
    }

    @Override
    public List<combinationClothes> findRecommendCombinationByUid(Integer uid) {
        return combinationMapper.findRecommendCombinationByUid(uid);
    }

    @Override
    public Integer deleteRecommendCombination(Integer uid) {
        return combinationMapper.deleteRecommendCombination(uid);
    }

    @Override
    public Integer deleteRecommendCombinationDetail(Integer uid) {
        return combinationMapper.deleteRecommendCombinationDetail(uid);
    }
}
