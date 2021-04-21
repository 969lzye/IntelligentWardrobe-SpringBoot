package com.fjnu.intelligentwardrobe;

import com.fjnu.intelligentwardrobe.Bean.clothes;
import com.fjnu.intelligentwardrobe.Bean.dto.combinationClothes;
import com.fjnu.intelligentwardrobe.Service.combinationService;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

@SpringBootTest
class IntelligentwardrobeApplicationTests {
    @Autowired
    com.fjnu.intelligentwardrobe.Service.combinationService combinationService;

    @Test
    void dataModelTest() throws Exception {
//        File file = new File("D:\\dataModel.txt");
//        if (file.exists()) { // 检查scores.txt是否存在
//            System.out.println("File already exists");
//        }
//        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\dataModel.txt"));
//        for(combinationClothes cc:combinationService.findCombinationByUid(2)){
//            for (clothes c:cc.getClothesList()){
//                System.out.print(cc.getCombinationid()+",");
//                System.out.print(c.getClothesid()+",");
//                System.out.println(c.getValue());
//                out.write(cc.getCombinationid()+","+c.getClothesid()+","+c.getValue());
//                out.write('\n');
//
//            }
//        }
//        out.close();
//        System.out.println();
        combinationService.addRecommendCombination(14,"推荐","zhiy");
    }
    @Test
    void UserItemTest() throws Exception {

        //用户-物品-评分数据文件
        String filePath = "D:\\dataModel.txt";

        //数据模型
        DataModel dataModel = null;

        try {
            //文件数据转换成数据模型
            dataModel = new FileDataModel(new File(filePath));

            /**
             * 物品相似度定义
             */

            //余弦相似度
            ItemSimilarity itemSimilarity = new UncenteredCosineSimilarity(dataModel);
            //欧几里得相似度
            //ItemSimilarity itemSimilarity= new EuclideanDistanceSimilarity(dataModel);
            //皮尔森相似度
            //ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);

            //定义推荐引擎
            Recommender recommender =new GenericItemBasedRecommender(dataModel, itemSimilarity);

//            //获取物品迭代器
//            LongPrimitiveIterator itemIDIterator = dataModel.getItemIDs();
//
//            //遍历所有物品
//            while(itemIDIterator.hasNext()){
//                System.out.println("==================================================");
//                Long itemID=itemIDIterator.next();
//                LongPrimitiveIterator otherItemIDIterator=dataModel.getItemIDs();
//                //打印物品相似度
//                while (otherItemIDIterator.hasNext()){
//                    Long otherItermID=otherItemIDIterator.next();
//                    System.out.println("衣服 "+itemID+" 与衣服 "+otherItermID+" 的相似度为： "+itemSimilarity.itemSimilarity(itemID,otherItermID));
//                }
//            }

            //获取用户迭代器
            LongPrimitiveIterator userIDIterator =dataModel.getUserIDs();

            //遍历用户
            while(userIDIterator.hasNext()){
                //获取用户
                Long userID=userIDIterator.next();
                //获取用户userID的推荐列表
                List<RecommendedItem> itemList= recommender.recommend(userID,2);
                if(itemList.size()>0){
                    for(RecommendedItem item:itemList){
                        System.out.println("组合 "+userID+" 推荐衣服 "+item.getItemID()+",衣服评分 "+item.getValue());
                    }
                }else {
                    System.out.println("组合 "+userID+" 无任何衣服推荐");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
