package com.asm.demo.tag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * 创建一个Handler文件，扩展自NamespaceHandlerSupport，目的是将组件注册到Spring容器。
 */
public class SelfNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("reference",new ReferenceBeanDefinitionParser());
    }
}
