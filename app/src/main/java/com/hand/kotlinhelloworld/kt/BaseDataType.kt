package com.hand.kotlinhelloworld.kt

/**
 * kotlin基本语法
 */

/**
 * top-level函数结构，fun+函数名+参数列表+返回值
 */
fun sum(a: Int, b: Int, c: Int): Unit {
}

/**
 * 函数表达式
 */
fun sum(a: Int, b: Int) = a + b

/**
 * public方法必须明确写出返回类型
 */
public fun multiply(a: Int, b: Int): Int {
    return 0
}


/**
 * 可变参数
 */
fun vars(vararg v: Int) {
    for (i in v) println(i)
}

/**
 * 返回类型是Uint可省略
 * 注意字符串模板$
 */
fun stringTemlate() {
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")} ,but now is $a"
    println(s2)
}

/**
 * 空安全
 */
fun nullCheck() {
    var age: String? = "123"
    var age3: String? = null
    val ages = age!!.toInt()//!!会判断该参数，如果为空则抛异常
    val age1 = age3?.toInt()//？会判断，为空，返回空
    val age2 = age3?.toInt() ?:/*"456"*/vars(4, 5, 6)//判断，为空，返回?:后类型或方法返回值
    println("$age --$ages--$age1-- $age2")
}

/**
 * 基本数据类型，没有char型
 */
fun baseDataType(): Int {
    var b: Byte = 0b1001//Byte8
    var s: Short = 5//Short16
    var i = 43 //Int32
    var l = 90L//Long64
    var f = 0.562f//Float32
    var d = 5.246//Double64

//    println("$b")

    var str = """
        dafdd
        adsff
        ada
        adf
    """.trim()
    println(str)


    return 0
}

/**
 * 遍历
 */
fun inDemo(): Int {
    var a = 4;
    if (a in 1..10) {
        return a
    }
    return 0
}

fun forEach() {
    val items = listOf<Int>(1, 20, 5, 4, 8, 6)
//    for (item in items){
//        println(item)
//    }

//    for (i in items.indices){
//        println("item at $i is ${items[i]}")
//    }

    items.forEach { print(it) }
}

/**
 * 类，class+类名+参数
 */
class BaseData(name: String) {

    var myName = name
    var currentName: String = name;

    init {
        println("$currentName is $name");
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun mutiply(a: Int, b: Int, c: Int) = a * b * c
}

/**
 * 中缀符号，函数调用方式可以跟普通函数不一样
 * 类参数如果加了var，则自动变成成员变量
 */
class Person(var name: String) {
    infix fun 说(word: String) {
        println("\"$name 说 $word\"")
    }

    infix fun 拉(a: Int) {
        println("\"$name 只拉了$a 次\"");
    }
}

/**
 * 扩展函数
 */
fun MutableList<Int>.swap(x: Int, y: Int) {
    val temp = this[x]
    this[x] = this[y]
    this[y] = temp
}


/**
 * 嵌套类
 * 嵌套类不能获取外部类的属性和方法
 */
class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}

/**
 * 内部类
 * 被嵌套到里面的类使用inner关键字修饰，内部类可以拥有对外部类的引用。但是外部类没有内部类的引用
 */
class Outer1 {
    private var bar: Int = 2

    inner class Inner {
        private var innerBar: Int = 5
        fun foo() = bar//访问外部类的成员变量
        fun foo1(){
            this@Outer1.bar = 5
            this.innerBar = 10
        }
    }
}

fun main(args: Array<String>) {
//    vars(1,2,3,5,8,10)
//    stringTemlate()
//    nullCheck()
//    baseDataType()
//    println("${inDemo()}")
//    forEach()

//    var baseDataType = BaseData("hand");
//    println("${baseDataType.sum(3,5)}")
//
//    println("${baseDataType.mutiply(2,3,6)}")

//    var  张俊 = Person("张俊")
//    张俊.说("小朋友，你好")
//    张俊 拉 1


//    val list = mutableListOf(1,2,3,4)
//    list.swap(0,2)
//    println(list)

//    var demo = Outer.Nested()
//    println(demo.foo())

}
