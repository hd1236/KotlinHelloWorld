package com.hand.kotlinhelloworld.kt

//解构1，赋值过程中，直接将一个对象的多个属性，赋值到多个变量中
class AdvancedPerson(private var name: String, var age: Int) {
    /**
     * 需使用operator关键字定义函数
     * 函数名称一定是component+数字
     */
    operator fun component1() = name

    operator fun component2() = age
}

//解构2，用于数据类遍历等
data class AdvancedPerson1(var name: String, var age: Int)

/**
 * 成员变量的get和set
 */
class User(var name: String) {

    var age = 5
    get() {
        return field+2
    }
    set(value) {
        field = value+2
    }

    fun changeName(name: String) {
        this.name = name
    }

    fun getChangeName(): String {
        return name
    }
}

/**
 * 遍历
 * 作用域函数和操作符
 */
fun main(args: Array<String>) {

//    var person = AdvancedPerson("hand",34)
//    var (name,age) = person
//    println("$name ---$age")
//
//    var person1 = AdvancedPerson1("hand1",33)
//    var(name1,age1) = person1
//    println("$name1 ---$age1")
//    val list = listOf<AdvancedPerson1>(
//        AdvancedPerson1("h",30),
//        AdvancedPerson1("a",31),
//        AdvancedPerson1("n",34)
//    )
//    list.forEach { (name,age)->println("$name ---$age") }
//    for ((name,age) in list){
//        println("for里面的$name ---$age")
//    }

    //作用域函数和操作符
//    /**
//     * let和run会返回闭包执行结果
//     * let有闭包参，用it
//     * run没有，用this
//     */
//    var user = User("hand")
//    var letRes = user
//        .let {
//            it.changeName("zhangj")
//            it.getChangeName()
//        }
//        .run { println("$this 在run里") }
//
//    /**
//     * also和apply不返回闭包结果，返回调用者本身，可链式
//     * also有闭包参，用it
//     * apply没有，用this
//     */
//    user
//        .also { it.name = "longj" }
//        .apply { print("${this.getChangeName()} 这次是apply") }

//    /**
//     * flatmap先创建一个新集合，然后遍历loc每个元素传入闭包，也就是it
//     * 闭包返回的集合添加到新集合中，遍历完后返回新集合
//     */
////    val loc = listOf("北京", "上海", "广州", "深圳", "杭州")
//    val loc = listOf(1, 3, 5, 7, 9)
//    var flatmap = loc.flatMap {
////        listOf(it,it+1)
//        var temp = it + 5
//        listOf(temp)
//    }
//    println(flatmap)


    var user1 = User("mens")
    user1.age = 10
    println("${user1.age}")
}