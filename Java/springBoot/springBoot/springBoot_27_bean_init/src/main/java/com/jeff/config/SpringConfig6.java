package com.jeff.config;

import com.jeff.bean.MyImportSelector;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Configuration;

@Import(MyImportSelector.class)
@Configuration  //加@Configuration注解flag=true
public class SpringConfig6 {
}
