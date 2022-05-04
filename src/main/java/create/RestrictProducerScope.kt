package create

import kotlin.coroutines.RestrictsSuspension

@RestrictsSuspension
class RestrictProducerScope<T> {

    suspend fun produce(value: T) {

    }
}