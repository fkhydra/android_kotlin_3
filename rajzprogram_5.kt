package com.example.rajzolas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
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

        //időzítő létrehozása, előkészítése, indítása
        myTimer = Timer()
        timerTask = object : TimerTask() {
            override fun run() {
                Idozitett_Muvelet()
            }
        }
        myTimer!!.schedule(timerTask, 100, 10)
    }

    //időzítő keretfüggvény
    fun Idozitett_Muvelet() {
        runOnUiThread(Futtathato_Kod)
    }

    //időzített műveletek
    var Futtathato_Kod = Runnable {
        //rajzlap!!.i += 2
        rajzlap?.invalidate()
        rajzlap?.leptet()
    }

}

class rajzvaszon(context: Context) : View(context)
{
    var paint:Paint = Paint()
    var i:Int=0
    var Y:Int=0

    init
    {
        i = 0
    }

    public fun leptet()
    {
        //println("timer..."+i)
        ++i
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(i > canvas?.width!!) {
            i=0
        }
        paint.setColor(Color.parseColor("#CD5C5C"))
        canvas.drawCircle(i.toFloat(),Y.toFloat()+50F,50F,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(event.action == MotionEvent.ACTION_DOWN)
        {
            println(""+event.x+","+event.y)
            i=event.x.toInt()
            Y=event.y.toInt()-50
        }
        return true
    }

}
