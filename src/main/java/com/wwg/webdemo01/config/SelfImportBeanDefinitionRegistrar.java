package com.wwg.webdemo01.config;

import com.wwg.webdemo01.model.TestD;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p></p>
 *
 * @author wangweiguang 2021/5/27 10:07
 */
public class SelfImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestD.class);
        registry.registerBeanDefinition("testD",rootBeanDefinition);
    }
}
