package com.example.rajzolas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

var rajzlap : rajzvaszon? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rajzlap=rajzvaszon(this)
        setContentView(rajzlap)
    }
}

class rajzvaszon(context: Context) : View(context)
{
    var paint:Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.parseColor("#CD0000"))
    }
}
