package ie.wit.calendar

    import android.widget.Toast.LENGTH_SHORT
    import android.content.Intent
    import android.os.Bundle
    import android.view.ViewGroup
    import android.widget.*
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.get
    import androidx.recyclerview.widget.LinearLayoutManager
    import ie.wit.adapters.EventAdapter
    import ie.wit.calendar.main.CalendarApp
    import kotlinx.android.synthetic.main.activity_agenda.*
    import kotlinx.android.synthetic.main.activity_main.*
    import kotlinx.android.synthetic.main.activity_time.*
    import kotlinx.android.synthetic.main.content_event.*
    import java.util.*


class Time : AppCompatActivity() {

    lateinit var app: CalendarApp

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_time)
            timePicker.setIs24HourView(true)
            app = this.application as CalendarApp
            recyclerView.adapter = EventAdapter(app.eventStore.findAll())
            recyclerView.layoutManager = LinearLayoutManager(this)


            val selectedDate = intent.getStringExtra("date")

            save_time_button.setOnClickListener{
                val toast = Toast.makeText(applicationContext, timePicker.hour.toString(), LENGTH_SHORT)
                toast.show()

                var hour = timePicker.hour
                var min = timePicker.minute
                val selectedTime = " $hour : $min"
                //eventTime.hint=selectedTime

                var intent = Intent(this, Event::class.java)
                intent.putExtra("time", selectedTime)
                intent.putExtra("date", selectedDate)
                startActivity(intent)

                        }
           /* agenda_button.setOnClickListener {
                var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("time", selectedTime)
            intent.putExtra("date", selectedDate)
                startActivity(intent)
            }*/
        }

}

