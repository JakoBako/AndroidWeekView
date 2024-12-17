package com.example.androidweekview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alamkanak.weekview.WeekView
import com.example.androidweekview.databinding.ActivityActiveEventsBinding
import java.util.Calendar

class ActiveEventsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActiveEventsBinding
    private val hardcodedEvents = listOf(
        MyEvent(
            id = "1",
            title = "Basketball Practice",
            startTime = Calendar.getInstance().apply { set(2024, 11, 16, 9, 0) },
            endTime = Calendar.getInstance().apply { set(2024, 11, 16, 11, 0) }
        ),
        MyEvent(
            id = "2",
            title = "Team Meeting",
            startTime = Calendar.getInstance().apply { set(2024, 11, 17, 14, 0) },
            endTime = Calendar.getInstance().apply { set(2024, 11, 17, 15, 0) }
        ),
        MyEvent(
            id = "3",
            title = "Game vs Rivals",
            startTime = Calendar.getInstance().apply { set(2024, 11, 18, 18, 0) },
            endTime = Calendar.getInstance().apply { set(2024, 11, 18, 20, 0) }
        ),
        MyEvent(
            id = "4",
            title = "Strategy Session",
            startTime = Calendar.getInstance().apply { set(2024, 11, 19, 10, 0) },
            endTime = Calendar.getInstance().apply { set(2024, 11, 19, 12, 0) }
        ),
        MyEvent(
            id = "5",
            title = "Recovery Session",
            startTime = Calendar.getInstance().apply { set(2024, 11, 20, 16, 0) },
            endTime = Calendar.getInstance().apply { set(2024, 11, 20, 17, 30) }
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActiveEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyCustomSimpleAdapter(this)
        binding.weekView.adapter = adapter

        adapter.submitList(hardcodedEvents)
    }
}