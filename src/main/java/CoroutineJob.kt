import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        logX("Coroutine start!")
        delay(1000L)
    }

    job.log()
    job.cancel()
    job.log()
    delay(1500L)
    // 协程执行结束后的回调
    // 如果job被取消了，invokeOnCompletion{}同样会执行
    job.invokeOnCompletion {
        logX("coroutine end ")
    }

    // 等待协程执行完毕
    // 挂起当前的程序执行流程，等待job当中的协程任务执行完毕，然后在恢复当前的程序执行流程
    job.join()
    logX("Process end!")

}

fun Job.log() {
    logX(
        """
        
        isActive = $isActive
        isCancelled = $isCancelled
        isCompleted = $isCompleted
        
    """.trimIndent()
    )
}

fun logX(any: Any?) {
    println(
        """
================================================            
$any
Thread:${Thread.currentThread().name}
================================================""".trimIndent()
    )
}