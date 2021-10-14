package dao;

import domain.Province;

import java.util.List;

public interface ProvinceDao {

    /**
     * 查询数据库中的所有省份
     * @return
     */
    public List<Province> findAll();
}
