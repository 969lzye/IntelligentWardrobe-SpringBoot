package com.fjnu.intelligentwardrobe.Controller;

import com.fjnu.intelligentwardrobe.Bean.type;
import com.fjnu.intelligentwardrobe.Service.ClothesService;
import com.fjnu.intelligentwardrobe.Service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private ClothesService clothesService;

    @RequestMapping("/getAllType")
    public List<type> getAllType(String uid){
        System.out.println("小程序查询uid="+uid+"的用户的所有衣服类型");

        return typeService.getAllTypeByUid(Integer.parseInt(uid));
    }

    @RequestMapping("/saveType")
    public Boolean saveType(String uid,String t_desc,String imgsrc){
        System.out.println("小程序前端调用，保存类型，参数："+uid+","+t_desc+","+imgsrc);
        return typeService.saveType(Integer.parseInt(uid),t_desc,imgsrc);
    }

    @RequestMapping("/findTypeByTypeid")
    public type findTypeByTypeid(String typeid){
        System.out.println("小程序前端根据typeid返回当前type的信息,typeid="+typeid);
        return typeService.findTypeByTypeid(Integer.parseInt(typeid));
    }

    @RequestMapping("/updateType")
    public Boolean updateType(String typeid, String t_desc, String imgsrc){
        System.out.println("小程序前端更新type信息，typeid="+typeid+",参数："+t_desc+","+imgsrc);
        if (typeService.updateType(Integer.parseInt(typeid),t_desc,imgsrc)>0)
            return true;
        else
            return false;
    }

    @RequestMapping("/deleteType")
    public  Boolean deleteType(String typeid){
        System.out.println("小程序前端删除type记录，typeid="+typeid);
        clothesService.deleteClothesByTypeid(Integer.parseInt(typeid));
        if (typeService.deleteType(Integer.parseInt(typeid))>0)
            return true;
        else
            return false;
    }
}
