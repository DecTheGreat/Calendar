package ie.wit.calendar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ie.wit.adapters.EventAdapter
import ie.wit.calendar.main.CalendarApp
import kotlinx.android.synthetic.main.activity_agenda.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*



class MainActivity : AppCompatActivity() {


    lateinit var app: CalendarApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app = this.application as CalendarApp
        recyclerView.adapter = EventAdapter(app.eventStore.findAll())
        recyclerView.layoutManager = LinearLayoutManager(this)


        save_date_button.setOnClickListener{
            val toast = Toast.makeText(applicationContext, Date(calendarView.date).toString(),
                Toast.LENGTH_SHORT).show()

            var sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            var selectedDate: String = sdf.format(Date(calendarView.getDate()))
            val intent = Intent(this, Time::class.java)
            intent.putExtra("date",selectedDate)
            startActivity(intent)

        }

        }

}



