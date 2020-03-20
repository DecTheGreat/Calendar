package ie.wit.calendar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import ie.wit.calendar.main.CalendarApp
import ie.wit.calendar.models.EventModel
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.content_event.*
import java.util.*



class Event : AppCompatActivity() {

    lateinit var app:CalendarApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        setSupportActionBar(toolbar)
        app = this.application as CalendarApp




        val selectedTime : String =intent.getStringExtra("time")
        val selectedDate: String =intent.getStringExtra("date")
        eventTime.setText(selectedTime )
        eventDate.setText(selectedDate )

        val toast = Toast.makeText(applicationContext, selectedTime, Toast.LENGTH_SHORT)
        toast.show()
        saveButton.setOnClickListener {
            app.eventStore.create(
                EventModel(
                    eventName = eventTitle.text.toString(),
                    eventDes = description.text.toString(),
                    eventTime = eventTime.text.toString(),
                    eventDate = eventDate.text.toString()
                )
            )
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

       /* agenda_button.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
*//*            intent.putExtra("time", selectedTime)
            intent.putExtra("date", selectedDate)*//*
            startActivity(intent)
        }*/

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }




}
