package create

import kotlinx.coroutines.delay
import kotlin.coroutines.*

/**
 * 创建一个协程
 * createCoroutine
 */

fun main() {
    val continuation = suspend {
        print("In Coroutine")
        5
    }.createCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine End $result")
        }
    })

    continuation.resume(Unit)



    val startContinuation = suspend {
        6
    }.startCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine 【start】End $result")
        }
    })
}

fun callLaunchCoroutine() {
    launchCoroutine(ProduceScope<Int>()) {
        println("In Coroutine")
        produce(200)
        delay(2000)
    }
}

fun <R, T> launchCoroutine(receiver: R, block: suspend R.() -> T) {
    block.startCoroutine(receiver, object : Continuation<T> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("Continue End : $result")
        }
    })
}


