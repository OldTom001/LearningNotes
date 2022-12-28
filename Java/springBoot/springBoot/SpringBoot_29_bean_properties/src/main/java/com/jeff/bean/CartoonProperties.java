package com.jeff.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


//@Component //在CartoonCatAndMouse类中用@EnableConfigurationProperties引用了这个类,  当CartoonCatAndMouse类被加载时, 会自动加载本类, 不再使用@Component
@ConfigurationProperties(prefix = "cartoon")
@Data
public class CartoonProperties {
    private Cat cat;
    private Mouse mouse;
}
