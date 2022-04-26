package com.wwg.webdemo01.config;

import com.wwg.webdemo01.model.TestA;
import com.wwg.webdemo01.model.TestB;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p></p>
 *
 * @author wangweiguang 2021/5/27 9:19
 */
@Configuration
@Import(value = {TestA.class, TestB.class,SelfImportSelector.class,SelfImportBeanDefinitionRegistrar.class})
public class ImportConfig {
}
