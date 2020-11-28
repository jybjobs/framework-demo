## 自定义标签解析

#### 步骤：
1. 创建一个需要扩展的组件。
2. 定义一个XSD文件描述组件内容。
3. 创建一个文件，实现BeanDefinitionParser接口，用来解析XSD文件中的定义和组件定义。
4. 创建一个Handler文件，扩展自NamespaceHandlerSupport，目的是将组件注册到Spring容器。
5. 编写Spring.handlers和Spring.schemas文件。

#### 测试：

Test.java
````
 ApplicationContext context = new ClassPathXmlApplicationContext("spring-demo.xml");
 Reference reference = (Reference) context.getBean("demo");
 System.out.printf("reference="+reference.toString());
 Assert.assertNotNull(reference);
 Assert.assertEquals(reference.getProtocol(),"rmi");
````