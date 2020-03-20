package ie.wit.calendar.models;

import java.util.*

interface EventStore {
    abstract val date: Date

    fun findAll() : List<EventModel>
    fun create(event: EventModel)
    fun findByDAte(date: Date): List<EventModel>
    fun update(event: EventModel)
    fun delete(event: EventModel)
    fun findById(id: Long) : EventModel?
}