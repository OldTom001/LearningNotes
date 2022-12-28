package com.jeff.bean;


import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.data.redis.core.RedisOperations;
import org.springframework.util.StringUtils;

//@Component //在启动类中使用@Import导入, 不再用@Component
@Data
@ConditionalOnClass(name="org.springframework.data.redis.core.RedisOperations")
@EnableConfigurationProperties(CartoonProperties.class) //设定某个类加载成bean
public class CartoonCatAndMouse{

    private CartoonProperties cartoonProperties;
    private Cat cat;
    private Dog dog;
    private Mouse mouse;

    //只有一个有参构造方法时, spring会自动调用这个有参构造方法(不走默认的无参构造), 可以自动装配, 不用写@Autowired.
    public CartoonCatAndMouse(CartoonProperties cartoonProperties){
        this.cartoonProperties = cartoonProperties;
        //若配置文件中有值, 则用配置文件中的值, 否则用自定义值
        cat = new Cat();
        cat.setName(cartoonProperties.getCat()!=null && StringUtils.hasText(cartoonProperties.getCat().getName())?cartoonProperties.getCat().getName():"tom");
        cat.setAge(cartoonProperties.getCat()!=null && cartoonProperties.getCat().getAge()!=null?cartoonProperties.getCat().getAge():3);

        mouse = new Mouse();
        mouse.setName(cartoonProperties.getMouse()!=null && StringUtils.hasText(cartoonProperties.getMouse().getName())?cartoonProperties.getMouse().getName():"jerry");
        mouse.setAge(cartoonProperties.getMouse()!=null && cartoonProperties.getMouse().getAge()!=null?cartoonProperties.getMouse().getAge():3);
    }

    public void play(){
        System.out.println(cat.getAge()+"岁的"+cat.getName()+"和"+ mouse.getAge()+"岁的"+ mouse.getName()+"打起来了");
    }
}