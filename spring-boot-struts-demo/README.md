# springboot + struts2 + feign demo

## 背景：
1. 在对旧技术栈进行升级过程中，由于遗留的struts2服务升级springmvc不可控因素比较多，且工作量大（主要是struts太灵活导致了很多不规范的使用）；
2. 如果不进行升级的话，很多高可用和治理能力需要定制化开发，导致更多的工作量，和升级风险。
3. 于是决定在不改变struts2的情况下，升级其他技术栈。

## 配置说明：
#### 前置要求：由于struts需要和spring集成，所以升级到4.x以上的版本
#### 配置 StrutsPrepareAndExecuteFilter （替代web.xml中的配置）
````.java
@Configuration
public class Struts2Configuration {
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new StrutsPrepareAndExecuteFilter());
        registration.addUrlPatterns("/*");
        registration.setName("StrutsPrepareAndExecuteFilter");
        return registration;
    }
}
````
#### struts.xml中增加配置
````struts.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <constant name="struts.devMode" value="true"/>
    <constant name="struts.enable.DynamicMethodInvocation" value="true"/><!-- 支持动态调用 -->
    <constant name="struts.objectFactory" value="spring"/>
    <constant name="struts.objectFactory.spring.autoWire" value="name" />
    <constant name="struts.convention.exclude.parentClassLoader" value="false" />
    <constant name="struts.convention.action.fileProtocols" value="jar,code-source" />
<!--    <constant name="struts.convention.default.parent.package" value="basicStruts"/>-->
<!--    <package name="basicStruts" extends="struts-default">-->
<!--        <action name="hello" class="com.sma.sboot.demo.action.Demo2Action" method="getTest">-->
<!--            <result name="index">/index.jsp</result>-->
<!--        </action>-->
<!--    </package>-->
</struts>
````
#### 其他springboot配置
* pom 引入
* 启动类

####注意：打包时打入webapp下资源文件
````
 <resource>
    <directory>src/main/webapp</directory>
    <targetPath>META-INF/resources</targetPath>
    <includes>
       <include>**/**</include>
    </includes>                
 </resource>            
````