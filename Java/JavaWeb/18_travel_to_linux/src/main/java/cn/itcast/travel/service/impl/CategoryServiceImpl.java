package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    /**
     * 查询旅游路线分类数据, 先在redis中查询, 若没有, 再到数据库中查询
     * @return
     */
    @Override
    public List<Category> findAll() {
        
        Jedis jedis = JedisUtil.getJedis();
        List<Category> cs = null;
        //查询redis
//        Set<String> categorys = jedis.zrange("category", 0, -1);
        //查询score
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);

        //redis中没有数据, 从数据库中查, 然后放到redis中
        if(categorys==null ||categorys.size()==0) {
            System.out.println("从数据库中查询...");
            cs = categoryDao.findAll();
            for (int i = 0; i < cs.size(); i++) {
                //将数据以sortedSet的格式存入redis, score是cid, 保证其顺序
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
            //redis中有数据, 直接从redis中查询
            cs = new ArrayList<Category>();
            //有数据, 从redis中取
            System.out.println("从redis中查询...");
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);
            }

        }
        return cs;
    }
}
