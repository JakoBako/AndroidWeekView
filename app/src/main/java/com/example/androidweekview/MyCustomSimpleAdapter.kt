// MyCustomSimpleAdapter.kt
package com.example.androidweekview

import android.content.Context
import android.widget.Toast
import com.alamkanak.weekview.WeekView
import com.alamkanak.weekview.WeekViewEntity
import java.util.Calendar

data class MyEvent(
    val id: String,
    val title: String,
    val startTime: Calendar,
    val endTime: Calendar
)

class MyCustomSimpleAdapter(private val appContext: Context) : WeekView.SimpleAdapter<MyEvent>() {

    override fun onCreateEntity(item: MyEvent): WeekViewEntity {
        val randomColor = android.graphics.Color.rgb(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        )

        return WeekViewEntity.Event.Builder(item)
            .setId(item.id.hashCode().toLong())
            .setTitle(item.title)
            .setStartTime(item.startTime)
            .setEndTime(item.endTime)
            .setStyle(WeekViewEntity.Style.Builder().setBackgroundColor(randomColor).build())
            .build()
    }

    override fun onEventClick(data: MyEvent) {
        Toast.makeText(appContext, "Clicked on: ${data.title}", Toast.LENGTH_SHORT).show()
    }
}
