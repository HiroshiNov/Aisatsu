package jp.techacademy.hiroshi.murata.aisatsuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.util.Log
import android.view.View
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View){
        showTimePickerDialog()
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                val time = hour * 60 + minute
                Log.d("hour , minute, time", "${hour},${minute},${time}")
                if (time < 120 || time >= 1080) { //Good evening
                    Log.d("Result","Good evening")
                    textView.text = "こんばんは"
                }else if (time >= 120 && time < 600 ){ //Good morning
                    Log.d("Result","Good morning")
                    textView.text = "おはよう"
                }else { //Hello
                    Log.d("Result","Hello")
                    textView.text = "こんにちは"
                }
            },
            0,0,true
        )
        timePickerDialog.show()
    }

}
