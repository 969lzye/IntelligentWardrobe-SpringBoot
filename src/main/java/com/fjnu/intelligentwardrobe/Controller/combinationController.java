package com.fjnu.intelligentwardrobe.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fjnu.intelligentwardrobe.Bean.clothes;
import com.fjnu.intelligentwardrobe.Bean.combination;
import com.fjnu.intelligentwardrobe.Bean.dto.ClothesListDto;
import com.fjnu.intelligentwardrobe.Bean.dto.combinationClothes;
import com.fjnu.intelligentwardrobe.Service.combinationService;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/combination")
public class combinationController {
    @Autowired
    private combinationService combinationService;
    @RequestMapping("/addCombination")
    public Integer addCombination(@Param("uid") String uid, @Param("c_desc") String c_desc,@Param("clothesarr") String clothesArr){
        System.out.println("小程序进行添加组合，参数："+uid+","+c_desc);
        //输出最后插入记录的自增主键值
        int combinationid=combinationService.addCombination(Integer.parseInt(uid),c_desc);
        System.out.println(combinationid);
        JSONArray ja=JSONArray.parseArray(clothesArr);
        for (int i=0;i<ja.size();i++){
            combinationService.addClothesToCombination(Integer.parseInt(uid),combinationid,Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(ja.get(i))).getString("clothesid")));
            System.out.println(JSONObject.parseObject(JSONObject.toJSONString(ja.get(i))).getString("clothesid"));
        }

        return 1;

    }

    @RequestMapping("/findCombinationByUid")
    public List<combinationClothes> findCombinationByUid(String uid){
        System.out.println("小程序查询用户："+uid+"下的所有组合");
        return combinationService.findCombinationByUid(Integer.parseInt(uid));
    }

    @RequestMapping("/findCombinationByCombinationid")
    public combinationClothes findCombinationByCombinationid(String combinationid){
        System.out.println("小程序查询组合"+combinationid+"详情");
        return combinationService.findCombinationBycombinationid(Integer.parseInt(combinationid));
    }

    @RequestMapping("/deleteCombination")
    public Integer deleteCombination(String combinationid){
        System.out.println("小程序删除组合："+combinationid);
        combinationService.deleteCombinationDetailed(Integer.parseInt(combinationid));
        return combinationService.deleteCombination(Integer.parseInt(combinationid));
    }

    @RequestMapping("updateCombination")
    public Integer updateCombination(String uid,String combinationid,String c_desc,String clothesArr){
        System.out.println("小程序修改组合："+combinationid+"信息");
        combinationService.deleteCombinationDetailed(Integer.parseInt(combinationid));
        JSONArray ja=JSONArray.parseArray(clothesArr);
        for (int i=0;i<ja.size();i++){
            combinationService.addClothesToCombination(Integer.parseInt(uid),Integer.parseInt(combinationid),Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(ja.get(i))).getString("clothesid")));
            System.out.println(JSONObject.parseObject(JSONObject.toJSONString(ja.get(i))).getString("clothesid"));
        }
        return combinationService.updateCombination(Integer.parseInt(combinationid),c_desc);
    }
}
