package suspends

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


suspend fun getUserInfo(): String {
    withContext(Dispatchers.IO) {
        delay(1000L)
    }
    return "userInfo"
}

suspend fun getFriendList(userInfo: String): String {
    withContext(Dispatchers.IO) {
        delay(500L)
    }
    return "friendList"
}

suspend fun getFeedList(friendInfo: String): String {
    withContext(Dispatchers.IO) {
        delay(200L)
    }
    return "feedList"
}

suspend fun testCoroutine() {
    println("start")
    val userInfo = getUserInfo()
    println(userInfo)
    val friendList = getFriendList(userInfo)
    println(friendList)
    val feedList = getFeedList(friendList)
    println(feedList)
}