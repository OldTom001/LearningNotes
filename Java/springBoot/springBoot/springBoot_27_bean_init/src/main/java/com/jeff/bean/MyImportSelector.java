package com.jeff.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //各种条件的判定，判定完毕后，决定是否装载指定的bean
        //importingClassMetadata意思是导入类的元数据, 谁导入的本类(MyImportSelector), 谁就是元数据
        boolean flag = importingClassMetadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        if(flag){
            return new String[]{"com.jeff.bean.Dog"};
        }
        return new String[]{"com.jeff.bean.Cat"};
    }
}
