package com.roundtableapps.timelinedayview

import android.app.TimePickerDialog
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.roundtableapps.timelinedayviewlibrary.EventView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import android.graphics.drawable.GradientDrawable



/**
 * @author R3ZA13 (Reza Abedini)
 * @since 18/11/18
 */
class MainActivity : AppCompatActivity() {

    private var fromValue: Float = 0f
    private var toValue: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvFrom.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                fromValue = hourOfDay.toFloat() + minute.toFloat() / 60
                tvFrom.text = "$hourOfDay:$minute"
            }, fromValue.toInt(), 0, false).show()
        }

        tvTo.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                toValue = hourOfDay.toFloat() + minute.toFloat() / 60
                tvTo.text = "$hourOfDay:$minute"
            }, toValue.toInt(), 0, false).show()
        }

        btnAdd.setOnClickListener {
            if (fromValue < toValue) {
                timeLine.addEvent(
                        EventView(this,
                                MyEvent().apply {
                                    startTime = fromValue
                                    endTime = toValue
                                },
                                itemsMargin = 1,
                                layoutResourceId = R.layout.item_event_two,
                                setupView = { myView ->
                                    myView.setBackgroundResource(R.drawable.radius_shape)
                                    val drawable = myView.background as GradientDrawable
                                    drawable.setColor(Color.argb(255, Random(System.currentTimeMillis()).nextInt() % 255, Random(System.currentTimeMillis()).nextInt() % 255, Random(System.currentTimeMillis()).nextInt() % 255))
                                    myView.background.alpha = 150
                                    myView.findViewById<TextView>(R.id.tvTitle).text = etTitle.text.toString()
                                },
                                onItemClick = { event ->
                                    Log.d("Item Clicked", event.myTitle)
                                }
                        )
                )
            } else {
                Toast.makeText(this, getString(R.string.time_error), Toast.LENGTH_SHORT).show()
            }
        }

    }

}
