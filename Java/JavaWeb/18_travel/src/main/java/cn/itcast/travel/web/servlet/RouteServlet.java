package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import com.fasterxml.jackson.databind.ser.Serializers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    
    private RouteService routeService = new RouteServiceImpl();
    FavoriteService favoriteService = new FavoriteServiceImpl();
    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        //线路名称(用户的搜索值), tomcat7不能自动处理get请求的中文乱码, 需要手动处理
        String rname = request.getParameter("rname");
        if(rname!=null && rname.length()>0) {
            //tomcat7需要手动处理乱码, tomcat8及以上可以自动处理
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }

        int cid = 0; //类别id
        //2. 接收参数
        //如果没有选择分类, 则传入的cid位字符串"null", 因此要做一个排除
        if(cidStr!=null && cidStr.length()>0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0; //当前页码, 默认值为1
        if(currentPageStr!=null && currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;
        if(pageSizeStr!=null && pageSizeStr.length()>0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }
        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize, rname); //这里没查到数据, 待修复
        //4. 将PageBean对象序列化为json
        writeValue(pb, response);
    }

    /**
     * 根据rid查询一个路线的详情信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接受rid
        String rid = request.getParameter("rid");
        //2. 调用service查询route对象
        Route route = routeService.findOne(rid);
        //3. 转为json写回客户端
        writeValue(route,response);

    }

    /**
     * 根据rid和用户信息(来自登录信息)查询是否收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 获取rid
        String rid = request.getParameter("rid");
        //2. 根据登录信息获取当前用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null){
            uid = 0;
        } else {
            uid = user.getUid();
        }

        //3. 调用favoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);
        //4. 写回客户端
        writeValue(flag, response);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid; //用户id
        //1. 获取rid
        String rid = request.getParameter("rid");
        //2. 获取登录信息
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            return;
        } else {
            uid = user.getUid();
        }
        favoriteService.add(rid,uid);
    }
}
