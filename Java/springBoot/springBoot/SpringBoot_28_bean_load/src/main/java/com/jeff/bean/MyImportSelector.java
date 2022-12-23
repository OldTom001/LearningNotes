package com.jeff.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        try {
            Class<?> clazz = Class.forName("com.jeff.bean.Mouse");
            if(clazz!=null){
                return new String[]{"com.jeff.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
            return new String[0];
        }
        return null;
    }
}
