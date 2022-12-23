package hi.zsl.service;

import hi.zsl.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {
    private Map<String,Integer> ipCountMap = new HashMap<String,Integer>();

    @Autowired
    //当前的request对象的注入工作由使用当前starter的工程提供自动装配
    private HttpServletRequest httpServletRequest;

    @Autowired
    private IpProperties ipProperties;

    public void count(){
        //每次调用当前操作，就记录当前访问的IP，然后累加访问次数
        //1.获取当前操作的IP地址
        String ip = httpServletRequest.getRemoteAddr();
//        System.out.println("---------------" + httpServletRequest.getRemoteAddr());
        //2.根据IP地址从Map取值，并递增

        ipCountMap.put(ip, ipCountMap.getOrDefault(ip,0) + 1);

/*        Integer count = ipCountMap.get(ip);
        if(count == null){
            ipCountMap.put(ip,1);
        }else{
            ipCountMap.put(ip,count + 1);
        }*/
    }

//    @Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print(){

        if(ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())){
            System.out.println("     IP访问监控(detail)");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%5d  |",key,value));
            }
            System.out.println("+--------------------+-------+");
        }else if(ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())){
            System.out.println(" IP访问监控(simple)");
            System.out.println("+-----ip-address-----+");
            for (String key: ipCountMap.keySet()) {
                System.out.println(String.format("|%18s  |",key));
            }
            System.out.println("+--------------------+");
        }
        //阶段内统计数据归零
        if(ipProperties.getCycleReset()){
            ipCountMap.clear();
        }
    }


}

