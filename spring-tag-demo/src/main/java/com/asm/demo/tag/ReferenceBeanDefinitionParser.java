package com.asm.demo.tag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;


/**
 * 实现BeanDefinitionParser接口，用来解析XSD文件中的定义和组件定义
 */
public class ReferenceBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Reference.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        String protocol = element.getAttribute("protocol");
        String clazz = element.getAttribute("clazz");

        if(StringUtils.hasText(id)) builder.addPropertyValue("id",id);
        if(StringUtils.hasText(protocol)) builder.addPropertyValue("protocol",protocol);
        if(StringUtils.hasText(clazz)) builder.addPropertyValue("clazz",clazz);
    }
}
