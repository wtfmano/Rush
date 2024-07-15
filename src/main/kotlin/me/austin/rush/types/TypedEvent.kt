package me.austin.rush.types

import me.austin.rush.enums.EventType

interface TypedEvent : Event {
    val type: EventType
}