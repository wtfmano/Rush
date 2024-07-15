package me.austin.rush.types

interface CancellableEvent : Event {
    var cancelled: Boolean

    fun isCancelled(): Boolean

    fun cancel()
}