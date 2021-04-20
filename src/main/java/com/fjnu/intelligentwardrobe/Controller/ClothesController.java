package com.fjnu.intelligentwardrobe.Controller;

import com.fjnu.intelligentwardrobe.Bean.clothes;
import com.fjnu.intelligentwardrobe.Service.ClothesService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
    @Autowired
    private ClothesService clothesService;

    @RequestMapping("/findClothesByTypeid")
    public List<clothes> findClothesByTypeid(String uid,String typeid){
        System.out.println("小程序查询用户："+uid+"下的类型为："+typeid+"的所有衣服");
        return clothesService.findClothesByTypeId(Integer.parseInt(uid),Integer.parseInt(typeid));
    }
    @RequestMapping("/addClothes")
    public Boolean addClothes(String uid,String desc,String typeid,String imgsrc,String season,String occasion){
        System.out.println("小程序前端保存衣服，参数："+uid+","+desc+","+typeid+","+season+","+occasion);
        return clothesService.addClothes(Integer.parseInt(uid),desc,Integer.parseInt(typeid),imgsrc,season,occasion);
    }

    @RequestMapping("/findClothesByClothesid")
    public List<clothes> findClothesByClothesid(String clothesid){
        System.out.println("小程序前端调用根据衣服id查找衣服，参数："+clothesid);
        return clothesService.findClothesByClothesId(Integer.parseInt(clothesid));
    }
    @RequestMapping("/updateClothesByClothesid")
    public Boolean updateClothesByClothesid(String uid, String c_desc, String typeid, String imgsrc, String season, String occasion, String clothesid){
        System.out.println("小程序前端调用：根据衣服id更新衣服，衣服id："+clothesid);
        return  clothesService.updateClothesByClothesid(Integer.parseInt(uid),c_desc,Integer.parseInt(typeid),imgsrc,season,occasion,Integer.parseInt(clothesid));
    }
    @RequestMapping("/deleteClothesByClothesid")
    public Boolean deleteClothes(String clothesid){
        System.out.println("小程序前端调用，根据衣服id删除衣服，衣服id："+clothesid);
        return clothesService.deleteClothes(Integer.parseInt(clothesid));
    }

    @RequestMapping("/findDirtyClothes")
    public List<clothes> findDirtyClothes(String uid){
        System.out.println("小程序查询不干净的衣服");
        return clothesService.findDirtyClothers(Integer.parseInt(uid));
    }

    @RequestMapping("/updateClothesStatus")
    public Integer updateClothesStatus(String clothesid,String status){
        System.out.println("小程序将衣服："+clothesid+"是否干净设置为"+status);
        return clothesService.updateClothesStatus(Integer.parseInt(clothesid),status);
    }
}
