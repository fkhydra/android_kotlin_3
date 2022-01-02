package com.example.php

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

 private var szoveg : String? = null

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_main)

  //szöveges mező előkészítése
  findViewById<TextView>(R.id.szoveg).text = "Nyomja le a gombot!"

  //nyomógomb előkészítése
  findViewById<Button>(R.id.gomb1).setOnClickListener {

   findViewById<TextView>(R.id.szoveg).text = "LEKÉRÉS…"
   //URL lekérése, a lenti csak példa
   Thread {
    val adatlekeres = halozat()
    try {
     szoveg =
      adatlekeres.lekeres("https://URLCIM/")
     runOnUiThread { findViewById<TextView>(R.id.szoveg).text = szoveg }
    } catch (e: IOException) {
     e.printStackTrace()
    }
   }.start()
  }
 }
}

//URL meghívása és a visszaadott
//kimenet összegyűjtésése
class halozat {
 @Throws(IOException::class)
 fun lekeres(url: String?): String {
  val tartalom = StringBuilder()

  //távoli kapcsolat felépítése és megnyitása
  println("open connection...")
  //val httpURLConnection: HttpURLConnection = _url.openConnection() as HttpURLConnection
  val httpURLConnection = URL(url).openConnection() as HttpURLConnection
  println("getresp code...")
  val responseCode: Int = httpURLConnection.getResponseCode()

  println("kezdes...")
  println("resp code:"+responseCode.toString())

  //kapcsolat ellenőrzése
  if (responseCode == HttpURLConnection.HTTP_OK) {
   println("http ok...")
   //kimenet visszaolvasásának előkészítése
   val inputStreamReader = InputStreamReader(httpURLConnection.getInputStream())
   val bufferedReader = BufferedReader(inputStreamReader)

   //kimenet összerakása
   var line: String?
   while (bufferedReader.readLine().also { line = it } != null) {
    tartalom.append(line)
   }
   try {
    bufferedReader.close()
   } catch (e: IOException) {
   }
  }

  //kapcsolat bontása
  httpURLConnection.disconnect()
  return tartalom.toString()
 }
}
