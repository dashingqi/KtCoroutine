import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        println("Coroutine started:${Thread.currentThread().name}")
        delay(1000L)
        println("Hello World!")
    }

    println("After launch:${Thread.currentThread().name}")
    Thread.sleep(2000L)
}

/**
 * launch 启动协程
 */
fun launchCoroutine() {
    // 生产环境不建议使用GlobalScope,仅用于研究
    // 同时GlobalScope类似于守护线程，会随着主线程的销毁而销毁
    GlobalScope.launch {
        // delay 是一个挂起函数，它是非阻塞的
        delay(1000L)
        println("Hello World")
    }
}

/**
 * runBlocking 启动协程
 */
fun runBlockingCoroutine() {
    // runBlocking 是阻塞式的
    // 会返回结果
    // 不能在正式的生产环境中使用
    val result = runBlocking {
        "result"
    }
}

fun asyncCoroutine(){

}