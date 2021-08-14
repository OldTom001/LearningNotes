package Annotation01;

import java.lang.annotation.*;

/**
 * 元注解: 用于描述注解的注解
 *
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE, ElementType.METHOD}) //表示注解只能作用于类和方法上, 加到成员变量上会报错
@Documented
public @interface MyAnno3 {
}
