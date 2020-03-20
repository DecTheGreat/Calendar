package ie.wit.calendar.main

import android.app.Application
import android.icu.util.Calendar
import android.util.Log
import ie.wit.calendar.models.EventMemStore
import ie.wit.calendar.models.EventStore
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class CalendarApp : Application() {

    lateinit var eventStore: EventStore

    override fun onCreate() {
        super.onCreate()
        eventStore = EventMemStore(date = Date(Calendar.getInstance().toString()) )
        Log.v("New Event","Calendar App started")
    }
}