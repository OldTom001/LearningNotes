package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import util.JedisPoolUtils;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllRedis() {
        //获取jedis
        Jedis jedis = JedisPoolUtils.getJedis();
        String province = jedis.get("province");
        //redis中没有数据
        if(province == null || province.length() == 0){
            System.out.println("redis中没有数据, 查询数据库");
            List<Province> ps = dao.findAll();
            //序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //添加到redis缓存
            jedis.set("province", province);
        } else {
            System.out.println("redis中有数据");
        }
        return province;
    }
}
