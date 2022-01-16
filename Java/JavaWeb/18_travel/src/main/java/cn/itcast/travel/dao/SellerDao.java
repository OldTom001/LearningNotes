package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {

    /**
     * 根据路线名称(rid)查询卖家信息
     * @param rid
     * @return
     */
    public Seller findByRid(int sid);
}
