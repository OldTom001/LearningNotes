package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * 线路service
 */
public interface RouteService {
    /**
     * 根据rid查询旅游路线详情
     * @param rid
     */
    public  Route findOne(String rid);

    /**
     * 根据类别进行分页查询
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);
}
