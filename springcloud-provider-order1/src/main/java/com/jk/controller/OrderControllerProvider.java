package com.jk.controller;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.service.OrderService;
import com.jk.service.OrderServiceFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class OrderControllerProvider implements OrderServiceFeign {

    @Resource
    private OrderService orderService;

    @GetMapping("/selectGoods")
    @Override
    public Map selectGoods(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        return orderService.selectGoods(page,rows);
    }

    @GetMapping("/findMyTree")
    @Override
    public List<TreeBean> findMyTree() {
        return orderService.findMyTree();
    }

    @PostMapping("/delGoods")
    @Override
    public void delGoods(@RequestParam("ids") String ids) {
        orderService.delGoods(ids);
    }

    @PostMapping("/saveGood")
    @Override
    public void saveGood(@RequestBody Goods goods) {
        orderService.saveGood(goods);
    }
}
