package com.hand.kotlinhelloworld.kt

import kotlinx.coroutines.*

/**
 * 协程，同线程里的异步
 * runBlocking执行协程任务，阻塞执行方法块
 * launch、async执行协程任务，可传Dispatchers对象指定操作线程，返回job对象
 * lounch返回的job，可以调用job.cancel取消执行，job.join等待任务结束
 * async返回的job，可以调用job.await等待执行完成
 */
fun block() = runBlocking {

    val job = launch {
        repeat(10) { i ->
            println("挂起中-------$i--${Thread.currentThread().name}")
            delay(1000L)
        }
    }

    val job2 = async(Dispatchers.IO) {
        println("async start--${Thread.currentThread().name}")
        delay(5000L)
        "我是 async 返回内容--${Thread.currentThread().name}"
    }

    println("async 开始--${Thread.currentThread().name}")
    println("job2返回的内容:${job2.await()}--${Thread.currentThread().name}")
    println("主线程等待--${Thread.currentThread().name}")
    delay(3000L)
    println("主线程结束等待--取消launch开启的协程--${Thread.currentThread().name}")
    job.cancel()

    println("主线程执行完--${Thread.currentThread().name}")
}

fun main(args: Array<String>) {
    println("main start--${Thread.currentThread().name}")
    block()
    println("main end--${Thread.currentThread().name}")


}