package hi.zsl.autoconfig;

import hi.zsl.intercepter.SpringMvcConfig;
import hi.zsl.properties.IpProperties;
import hi.zsl.service.IpCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import({IpProperties.class, SpringMvcConfig.class})
public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}
