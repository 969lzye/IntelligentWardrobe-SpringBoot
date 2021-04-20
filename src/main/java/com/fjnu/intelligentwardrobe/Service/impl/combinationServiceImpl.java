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
    public Integer addCombination( Integer uid, String c_desc) {
        combinationMapper.addCombination(uid,c_desc);
        return combinationMapper.getLastInsertId();
    }

    @Override
    public Integer addClothesToCombination(Integer uid,Integer combinationId, Integer clothesId) {
        return combinationMapper.addClothesToCombination(uid,combinationId,clothesId);
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
    public Integer updateCombination(Integer combinationid, String c_desc) {
        return combinationMapper.updateCombination(combinationid,c_desc);
    }
}
