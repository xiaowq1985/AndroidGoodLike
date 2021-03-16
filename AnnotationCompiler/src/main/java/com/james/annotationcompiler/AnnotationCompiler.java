package com.james.annotationcompiler;

import com.google.auto.service.AutoService;
import com.james.annotation.BindView;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
public class AnnotationCompiler extends AbstractProcessor {
    Filer filer;

    //支持Java版本
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


    //支持的注解Set
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new HashSet<>();
        set.add(BindView.class.getCanonicalName());
        return set;
    }

    //生成文件
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        filer = processingEnvironment.getFiler();
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        return false;
    }
}