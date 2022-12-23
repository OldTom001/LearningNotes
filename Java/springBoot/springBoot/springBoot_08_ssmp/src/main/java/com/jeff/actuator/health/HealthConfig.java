package com.jeff.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HealthConfig extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition = true;
        //模拟一个加载环境, 若加载成功则显示up状态, 否则显示outOfService状态
        if(condition) {
            builder.status(Status.UP);					//设置运行状态为启动状态
            builder.withDetail("runTime", System.currentTimeMillis());
            Map infoMap = new HashMap();
            infoMap.put("buildTime", "2006");
            builder.withDetails(infoMap);
        }else{
            builder.status(Status.OUT_OF_SERVICE);		//设置运行状态为不在服务状态
            builder.withDetail("上线了吗？","你做梦");
        }
    }
}
