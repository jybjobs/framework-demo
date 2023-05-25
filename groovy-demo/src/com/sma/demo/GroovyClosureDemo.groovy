
// 5. 闭包
//闭包是一种表示可以执行代码块的方法，且闭包也是对象，可以像方法一样传递参数。在声明闭包后，可以使用并修改其作用域内的所有变量值。

// 参数化的闭包
def closure = { name -> println "Hello ${name}" }
closure.call("Groovy") // Hello Groovy
// 省略了call
closure("Gradle") // Hello Gradle

//在闭包中，如果只有一个形参时，可以省略形参名，直接只用隐参数it；当有多个参数时，it就不能表示了
// 单个隐参数
def closure2={println "hello ${it}"}
closure2.call("Groovy") //hello Groovy
closure2("Gradle")
//自定义遍历Map的函数，参数接受一个闭包
def eachMap(closure){
    def map=['name':'xiaoming','age':12]
    map.each{
        closure.call(it.key,it.value)
    }
}
// 多个参数
eachMap{
    k,v -> println "${k},${v}"
}

/**
 * 闭包关键变量
 Groovy闭包的强大之处在于它支持闭包方法的委托。Groovy的闭包有this、owner、delegate这三个属性，当在闭包内调用方法时，由它们来确定使用哪个对象来处理。

 默认情况下delegate和owner是相等的，但是delegate是可以修改的，Gradle中的闭包很多功能都是通过修改delegate实现的。

 下面讨论this、owner、delegate闭包三个重要变量：

 this代表闭包定义处的类
 owner代表闭包定义处的类或者对象
 delegate代表任意对象，默认与owner一致

 */

def scriptClouser = {
    println "scriptClouser this: " + this
    println "scriptClouser owner: " + owner
    println "scriptClouser delegate: " + delegate
}
scriptClouser.call()



class Person{
    def static classClouser = {
        println "classClouser this: " + this
        println "classClouser owner: " + owner
        println "classClouser delegate: " + delegate
    }

    def static speech() {
        def methodClassClouser = {
            println "methodClassClouser this: " + this
            println "methodClassClouser owner: " + owner
            println "methodClassClouser delegate: " + delegate
        }

        methodClassClouser.call()
    }
}

Person.classClouser.call()
Person.speech()


def outerClouser = {
    def innerClouser = {
        println "innerClouser this: " + this
        println "innerClouser owner: " + owner
        println "innerClouser delegate: " + delegate
    }
    innerClouser.call()

    // 如果修改innerClouser 闭包的delegate，打印信息
    innerClouser.delegate = new Person()
    innerClouser.owner = new Person() //没有被修改
    innerClouser.call()
}

outerClouser.call()


