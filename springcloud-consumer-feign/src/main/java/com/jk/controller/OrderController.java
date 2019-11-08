package com.jk.controller;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.service.OrderServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController{

    @Resource
    private OrderServiceFeign orderServiceFeign;

    @RequestMapping("/selectGoods")
    public Map selectGoods(Integer page, Integer rows){
        return orderServiceFeign.selectGoods(page,rows);
    }

    @RequestMapping("/findMyTree")
    public List<TreeBean> findMyTree(){
        return orderServiceFeign.findMyTree();
    }

    @RequestMapping("/saveGood")
    public Boolean saveGood(Goods goods){
        try {
            orderServiceFeign.saveGood(goods);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/delGoods")
    public Boolean delGoods(String ids){
            try {
                orderServiceFeign.delGoods(ids);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
    }
}
