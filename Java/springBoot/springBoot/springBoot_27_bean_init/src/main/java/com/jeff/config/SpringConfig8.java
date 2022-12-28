package com.jeff.config;

import com.jeff.bean.MyPostProcessor;
import com.jeff.bean.MyRegistrar81;
import com.jeff.bean.MyRegistrar82;
import com.jeff.bean.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

@Import({BookServiceImpl1.class, MyRegistrar81.class, MyRegistrar82.class, MyPostProcessor.class})
public class SpringConfig8 {
}
