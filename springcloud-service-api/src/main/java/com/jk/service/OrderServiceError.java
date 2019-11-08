package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OrderServiceError implements OrderServiceFeign {
    public Map selectGoods(Integer page, Integer rows) {
        return null;
    }

    public List<TreeBean> findMyTree() {
        return null;
    }

    public void delGoods(String ids) {

    }

    public void saveGood(Goods goods) {

    }
}
