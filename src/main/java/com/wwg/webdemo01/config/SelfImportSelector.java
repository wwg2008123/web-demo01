package com.wwg.webdemo01.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p></p>
 *
 * @author wangweiguang 2021/5/27 9:52
 */
public class SelfImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.wwg.webdemo01.model.TestC"};
    }
}
