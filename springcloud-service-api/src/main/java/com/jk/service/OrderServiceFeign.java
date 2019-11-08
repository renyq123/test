package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "PROVIDER-ORDER1", fallback = OrderServiceError.class)
public interface OrderServiceFeign {

    @GetMapping("/selectGoods")
    Map selectGoods(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @GetMapping("/findMyTree")
    List<TreeBean> findMyTree();

    @PostMapping("/delGoods")
    void delGoods(@RequestParam("ids") String ids);

    @PostMapping("/saveGood")
    void saveGood(@RequestBody Goods goods);
}
