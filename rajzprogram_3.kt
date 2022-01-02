package com.example.rajzolas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.*

var rajzlap : rajzvaszon? = null

class MainActivity : AppCompatActivity() {

    private var myTimer: Timer? = null
    private var timerTask: TimerTask? = null

    //private var paint:Paint = Paint()
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
    var szinertek:Int=0

    init
    {
        i = 0
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for(i in 0..canvas?.height!!) {
            szinertek=(255F*i.toFloat()/canvas.height.toFloat()).toInt()
            paint.setARGB(255,szinertek,szinertek,szinertek)
            canvas.drawLine(0.toFloat(),i.toFloat(),canvas.width.toFloat(),i.toFloat(),paint)
        }
    }

}
