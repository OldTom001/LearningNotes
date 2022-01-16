package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {
    /**
     * 根据旅游路线名称(rid)查询图片列表
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);
}
