package service;

import domain.Province;

import java.util.List;

public interface ProvinceService {

    /**
     * 查找数据库中的所有省份
     * @return
     */
    public List<Province> findAll();

    /**
     * 先查询redis缓存, 若缓存中没有数据, 再查询数据库, 并更新到缓存
     */
    public String findAllRedis();

}
