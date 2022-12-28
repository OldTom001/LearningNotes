package com.jeff.config;

import com.jeff.bean.Dog;
import org.springframework.context.annotation.Import;

@Import({Dog.class,DbConfig.class})
public class SpringConfig4 {
}
