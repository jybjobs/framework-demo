# maven study demo

## 基础

#### 1. 目录约定
````
// 主代码
src/main/java
src/main/resources
// 测试代码
src/test/java
src/test/resources
````

#### 2. build plugins

* 构建: maven-compiler-plugin
* 打包: maven-shade-plugin
* 生成项目骨架: maven-archetype-plugin 
    > mvn archetype:generate

## 坐标和依赖
#### 坐标

```
Maven坐标为各种构件引入了秩序，任何一个构件都必须明确定义自己的坐标，而一组Maven坐标是通过一些元素定义的，
它们是groupId、artifactId、version、packaging、classifier
groupId：定义当前Maven项目隶属的实际项目。groupId的表示方式与Java包名的表示方式类似，通常与域名反向一一对应
artifactId：该元素定义实际项目中的一个Maven项目（模块），推荐的做法是使用实际项目名称作为artifactId的前缀
version：该元素定义Maven项目当前所处的版本
packaging：该元素定义Maven项目的打包方式。首先，打包方式通常与所生成构件的文件扩展名对应,默认为jar
classifier：该元素用来帮助定义构建输出的一些附属构件，如：javadoc和sources就是这两个附属构件的classifie。
```
## 注意：
* Maven 3中，即使用户没有指定版本，Maven会解析最新的稳定版本