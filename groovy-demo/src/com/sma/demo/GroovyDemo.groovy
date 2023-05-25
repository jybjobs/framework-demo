/**
 * Groovy 语法基础
 */
//1. print
println("Hello,Groovy!");

println "Hello,Groovy!"

//2. String
def string = "Hello Groovy"
println string[1]  // e
println string[-1]  // y
println string[1..2]  // el    [1..2]表示1到2的范围
println string[1..<3]  // el

println "Hello" + " Groovy" // Hello Groovy 字符串的合并，相当于"Hello".plus(" Groovy")
println "Hello" * 3   // HelloHelloHello 字符串的赋值
println string - "Groovy" // Hello  删除首次出现的字符串
println string.length()   // 12 获取字符串的长度
println string.size()     // 12 获取字符串的长度
println string.contains("Groovy")  // true 字符串中是否包含指定的子字符串
println string.count("o")   // 3 统计某个子字符串出现的次数

// 3. 集合
// 可以在Groovy中直接创建ArrayList方式，但是太繁琐
def list = new ArrayList()
println list.getClass() // class java.util.ArrayList

// Groovy定义方式
def list2 = [11, 12, 13, 14]
println list2.class // class java.util.ArrayList

//指定集合的类型有两种方式
//方式1 通过 as 操作符来指定
//方式2 通过强类型定义的方式来指定

def list3 = [1, 2, 3] as LinkedList
println list3.class//class java.util.LinkedList
LinkedList list4 = [4, 5, 6]
println list4.class//class java.util.LinkedList

// 可以嵌套不同类型元素
def list5 = [12, 23, "kerwin", [32, 43]]

def list6 = [11, 12, 13, 14]
list.each {
    println "${it}"
}

// map
def map =[1:"java",2:"c"]
println map.get(1)//java
println map[1]//java

// 4. 数组类型定义
//Groovy中使用[] 表示就是一个 List 集合,如果要定义 Array ,那么就必须要强制指定为一个数组类型。
//使用强类型定义
String[] arr1 = ["Java", "Groovy", "Golang"]

assert arr1 instanceof String[]

//使用 as 关键字定义数组
def arr2 = ["Java", "Groovy", "Golang"] as String[]

assert arr2 instanceof String[]






