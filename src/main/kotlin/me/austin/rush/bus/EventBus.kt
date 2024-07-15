package me.austin.rush.bus

import me.austin.rush.listener.Listener
import me.austin.rush.types.Event
import me.austin.rush.types.StoppableEvent

/**
 * Basic structure for an event dispatcher.
 *
 * @author Austin
 * @since 2022
 */
interface EventBus {
    /**
     * Adds the listener into the registry.
     *
     * @param listener Instance of [Listener] to subscribe.
     */
    fun subscribe(listener: Listener)

    /**
     * Adds all [Listener] objects to the registry.
     *
     * @param listeners All [Listener] objects you want to be added.
     */
    fun subscribeAll(vararg listeners: Listener) {
        for (listener in listeners) {
            this.subscribe(listener)
        }
    }

    /**
     * Adds all [Listener] objects in an [Iterable] to the registry.
     *
     * @param listeners The [Iterable] of [Listener] objects you want to be added.
     */
    fun subscribeAll(listeners: Iterable<Listener>) {
        for (listener in listeners) {
            this.subscribe(listener)
        }
    }

    /**
     * Removes the listener from the registry.
     *
     * @param listener [Listener] object to be removed.
     */
    fun unsubscribe(listener: Listener)

    /**
     * Removes all [Listener] objects from the registry.
     *
     * @param listeners [Listener] objects you want to be removed.
     * @see unsubscribe
     */
    fun unsubscribeAll(vararg listeners: Listener) {
        for (listener in listeners) {
            this.unsubscribe(listener)
        }
    }

    /**
     * Removes all [Listener] objects in an [Iterable] from the registry.
     *
     * @param listeners [Iterable] of [Listener] objects you want to be removed.
     * @see unsubscribe
     */
    fun unsubscribeAll(listeners: Iterable<Listener>) {
        for (listener in listeners) {
            this.unsubscribe(listener)
        }
    }

    fun <T : Event> post(event: T): T

    fun <T : StoppableEvent> post(event: T): T
}