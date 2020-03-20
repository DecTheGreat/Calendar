package ie.wit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.calendar.R
import ie.wit.calendar.models.EventModel
import kotlinx.android.synthetic.main.event_card.view.*


class EventAdapter constructor(private var events: List<EventModel>)
    : RecyclerView.Adapter<EventAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.event_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        var event = events[holder.adapterPosition]
            holder.bind(event)
    }

    override fun getItemCount(): Int = events.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(event: EventModel) {
            itemView.eventTitle.setText(event.eventName)
            itemView.eventTime.setText(event.eventTime)
            itemView.eventDate.setText(event.eventDate)

        }
    }
}