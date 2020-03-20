package ie.wit.calendar.models

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.ArrayList

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}
val events = ArrayList<EventModel>()
 class EventMemStore(override val date: Date) : EventStore {



        override fun findAll(): List<EventModel> {
            return events
        }

        override fun findByDAte(eventDate: Date):List<EventModel> {
            var dateList : List<EventModel> = events.filter { e -> e.eventDate.equals(eventDate) }
            return dateList.sortedByDescending { it.eventTime }


           /* val foundEvent: EventModel? = events.find{it.eventDate.equals(eventDate)}
            return foundEvent*/
        }
        override fun findById(id: Long) : EventModel? {
            val foundEvent: EventModel? = events.find {e-> e.id == id }
            return foundEvent
        }
        override  fun create(event: EventModel) {
            event.id = getId()
            events.add(event)
            logAll()

        }

     override fun update(event: EventModel) {
         var foundEvent:EventModel? = events.find { e -> e.id == event.id }
         if(foundEvent != null)
         {
            foundEvent.eventName = event.eventName
             foundEvent.eventDate = event.eventDate
             foundEvent.eventTime = event.eventTime
             foundEvent.eventDes = event.eventDes
             logAll()
         }
     }

     override fun delete(event: EventModel) {
         var deletedId : Int = events.indexOf(events.find { e -> e.id == event.id })
         events.removeAt(deletedId)

         var foundEvent:EventModel? = events.find { e -> e.id == event.id }

     }

        fun logAll() {
            Log.v("Event","** Events List **")
            events.forEach { Log.v("Event","${it}") }
        }

}