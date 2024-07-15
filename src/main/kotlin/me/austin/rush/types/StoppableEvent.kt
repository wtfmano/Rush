package me.austin.rush.types

interface StoppableEvent : Event {
    var stopped: Boolean
    
    fun isStopped(): Boolean

    fun stop()
}