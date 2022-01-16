package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public Route findOne(String rid) {
        //1. 根据路线名称(rid)查询路线信息
        Route route = routeDao.findOne(Integer.parseInt(rid));
        //2. 根据路线名称(rid)查询图片信息
        List<RouteImg> routeImg = routeImgDao.findByRid(route.getRid());
        route.setRouteImgList(routeImg);
        //3. 根据路线名称(rid)查询卖家信息
        Seller seller = sellerDao.findByRid(route.getSid());
        route.setSeller(seller);
        //4. 查询收藏次数
        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);
        return route;
    }

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pageBean = new PageBean<Route>();
        int totalCount = routeDao.findTotalCount(cid, rname);
        int totalPage = totalCount % pageSize == 0?totalCount / pageSize: totalCount / pageSize+1;
        List<Route> page = routeDao.findByPage(cid, (currentPage-1)*pageSize, pageSize, rname);
        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(page);

        return pageBean;
    }
}
