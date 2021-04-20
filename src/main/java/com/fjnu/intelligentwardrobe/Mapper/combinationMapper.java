package com.fjnu.intelligentwardrobe.Mapper;

import com.fjnu.intelligentwardrobe.Bean.combination;
import com.fjnu.intelligentwardrobe.Bean.combinationDetail;
import com.fjnu.intelligentwardrobe.Bean.dto.combinationClothes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface combinationMapper {
    Integer addCombination(Integer uid,String c_desc);
    Integer addClothesToCombination(Integer uid,Integer combinationId,Integer clothesId);
    Integer getLastInsertId();
    List<combinationClothes> findCombinationByUid(Integer uid);
    combinationClothes findCombinationBycombinationid(Integer combinationid);
    Integer deleteCombination(Integer combinationid);
    Integer deleteCombinationDetailed(Integer combinationid);
    Integer updateCombination(Integer combinationid,String c_desc);
}
