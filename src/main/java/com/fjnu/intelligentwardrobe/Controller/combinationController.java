package com.fjnu.intelligentwardrobe.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fjnu.intelligentwardrobe.Bean.clothes;
import com.fjnu.intelligentwardrobe.Bean.combination;
import com.fjnu.intelligentwardrobe.Bean.dto.ClothesListDto;
import com.fjnu.intelligentwardrobe.Bean.dto.combinationClothes;
import com.fjnu.intelligentwardrobe.Service.ClothesService;
import com.fjnu.intelligentwardrobe.Service.combinationService;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.ibatis.annotations.Param;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/combination")
public class combinationController {
    @Autowired
    private combinationService combinationService;
    @Autowired
    private ClothesService clothesService;
    @RequestMapping("/addCombination")
    public Integer addCombination(@Param("uid") String uid, @Param("c_desc") String c_desc,String occasion,@Param("clothesarr") String clothesArr,@Param("clothevaluesarr") String clothesValueArr){
        System.out.println("小程序进行添加组合，参数："+uid+","+c_desc);
        //输出最后插入记录的自增主键值
        int combinationid=combinationService.addCombination(Integer.parseInt(uid),c_desc,occasion);
        System.out.println(combinationid);
        JSONArray ca=JSONArray.parseArray(clothesArr);
        JSONArray cva=JSONArray.parseArray(clothesValueArr);
        for (int i=0;i<ca.size();i++){
            combinationService.addClothesToCombination(Integer.parseInt(uid),combinationid,
                    Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(ca.get(i))).getString("clothesid")),
                    Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(cva.get(i))).getString("value"))
                    );
            System.out.println(JSONObject.parseObject(JSONObject.toJSONString(ca.get(i))).getString("clothesid"));
            System.out.println(JSONObject.parseObject(JSONObject.toJSONString(cva.get(i))).getString("value"));
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
    public Integer updateCombination(String uid,String combinationid,String c_desc,String occasion,String clothesArr,String clothesValueArr){
        System.out.println("小程序修改组合："+combinationid+"信息");
        combinationService.deleteCombinationDetailed(Integer.parseInt(combinationid));
        JSONArray ca=JSONArray.parseArray(clothesArr);
        JSONArray cva=JSONArray.parseArray(clothesValueArr);
        for (int i=0;i<ca.size();i++){
            combinationService.addClothesToCombination(Integer.parseInt(uid),Integer.parseInt(combinationid),
                    Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(ca.get(i))).getString("clothesid")),
                    Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(cva.get(i))).getString("value"))
                    );
            System.out.println(JSONObject.parseObject(JSONObject.toJSONString(ca.get(i))).getString("clothesid"));
        }
        return combinationService.updateCombination(Integer.parseInt(combinationid),c_desc,occasion);
    }

    @RequestMapping("/findRecommendCombination")
    public List<combinationClothes> findRecommendCombination(String uid,String occasion) throws Exception {
        combinationService.deleteRecommendCombination(Integer.parseInt(uid));
        combinationService.deleteRecommendCombinationDetail(Integer.parseInt(uid));
        System.out.println("小程序为用户："+uid+"推荐场合："+occasion+"下的套装");
        File file = new File("D:\\dataModel.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\dataModel.txt"));
        List<combinationClothes> list=combinationService.findRecommendCombination(Integer.parseInt(uid),occasion);
        for(combinationClothes cc:list){
            for (clothes c:cc.getClothesList()){
                out.write(cc.getCombinationid()+","+c.getClothesid()+","+c.getValue());
                out.write('\n');

            }
        }
        out.close();
        //用户-物品-评分数据文件
        String filePath = "D:\\dataModel.txt";

        //数据模型
        DataModel dataModel = null;

        try {
            //文件数据转换成数据模型
            dataModel = new FileDataModel(new File(filePath));
            //余弦相似度
            ItemSimilarity itemSimilarity = new UncenteredCosineSimilarity(dataModel);
            //定义推荐引擎
            Recommender recommender =new GenericItemBasedRecommender(dataModel, itemSimilarity);
                        //获取物品迭代器
            LongPrimitiveIterator itemIDIterator = dataModel.getItemIDs();

            //遍历所有物品
            while(itemIDIterator.hasNext()){
                System.out.println("==================================================");
                Long itemID=itemIDIterator.next();
                LongPrimitiveIterator otherItemIDIterator=dataModel.getItemIDs();
                //打印物品相似度
                while (otherItemIDIterator.hasNext()){
                    Long otherItermID=otherItemIDIterator.next();
                    System.out.println("衣服 "+itemID+" 与衣服 "+otherItermID+" 的相似度为： "+itemSimilarity.itemSimilarity(itemID,otherItermID));
                }
            }
            //获取用户迭代器
            LongPrimitiveIterator userIDIterator =dataModel.getUserIDs();
            //遍历用户
            while(userIDIterator.hasNext()){
                //获取用户
                Long userID=userIDIterator.next();
                //获取用户userID的推荐列表
                List<RecommendedItem> itemList= recommender.recommend(userID,2);
                if(itemList.size()>0){

                    int combinationid=combinationService.addRecommendCombination(Integer.parseInt(uid),occasion+"推荐",occasion);
                    System.out.println(combinationid);
                    System.out.print("组合 "+userID);
                    for(RecommendedItem item:itemList){
                        System.out.print(" 推荐衣服 "+item.getItemID()+",衣服评分 "+item.getValue());
                        Integer clothesid=(int)item.getItemID();
                        Integer value=(int)item.getValue();
                        combinationService.addClothesToRecommendCoombination(Integer.parseInt(uid),combinationid,clothesid,value);
                    }
                    System.out.println();
                }else {
                    System.out.println("组合 "+userID+" 无任何衣服推荐");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return combinationService.findRecommendCombinationByUid(Integer.parseInt(uid));
    }
}
