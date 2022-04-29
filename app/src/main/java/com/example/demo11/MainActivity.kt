package com.example.demo11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ConstraintLayout>(R.id.rootLayout).setOnTouchListener(this)

    }


    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        //val coord = "(${p1!!.x},${p1.y})"
        val coord = "(%.2f, %.2f)".format(p1!!.x, p1.y)
        val textView = findViewById<TextView>(R.id.textView1)
        when (p1.action) {
            MotionEvent.ACTION_DOWN -> textView.text = "clicked down at ${coord}"
            MotionEvent.ACTION_UP -> textView.text = "release up at ${coord}"
            MotionEvent.ACTION_MOVE->textView.text = "move to ${coord}"
        }
        return true
    }
}

