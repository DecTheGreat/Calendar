package ie.wit.calendar.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventModel(
    var id: Long =0,
    var eventName: String,
    var eventDes: String,
    var eventTime: String,
    var eventDate: String
) : Parcelable

