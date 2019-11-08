package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select count(1) from t_good")
    int findOrderListCount();
    

    @Select("select id,url as path,pid,text from t_power where pid = #{value}")
    List<TreeBean> findTreeNodeList(Integer id);

    @Select("select * from t_good limit #{start},#{end}")
    List<Goods> findOrderList(HashMap<String, Object> params);

    @Delete("delete  from t_good where goodId in ( ${ids})")
    void delGoods(String ids);

    @Insert("insert into t_good(goodName,goodPrice) values(#{goodName},#{goodPrice})")
    void saveGood(Goods goods);
}
