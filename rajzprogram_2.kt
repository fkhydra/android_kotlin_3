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
    var i:Int=0
    var magassag:Int = 0

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        magassag = (canvas?.height!!/ 20).toInt() - 5
        canvas.drawColor(Color.parseColor("#FFFFFF"))
        paint.setColor(Color.parseColor("#CD5C5C"))
        for (i in 0..magassag)
        {
            canvas.drawCircle(200F,i.toFloat()*20F,5F,paint)
        }
    }
}
