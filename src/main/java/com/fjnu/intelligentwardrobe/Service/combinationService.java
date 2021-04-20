package com.fjnu.intelligentwardrobe.Service;

import com.fjnu.intelligentwardrobe.Bean.combination;
import com.fjnu.intelligentwardrobe.Bean.dto.combinationClothes;

import java.util.List;

public interface combinationService {
    Integer addCombination(Integer uid,String c_desc);
    Integer addClothesToCombination(Integer uid,Integer combinationId,Integer clothesId);
    List<combinationClothes> findCombinationByUid(Integer uid);
    combinationClothes findCombinationBycombinationid(Integer combinationid);
    Integer deleteCombination(Integer combinationid);
    Integer deleteCombinationDetailed(Integer combinationid);
    Integer updateCombination(Integer combinationid,String c_desc);
}
