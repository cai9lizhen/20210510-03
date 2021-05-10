package com.example.a20210510_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var x:Int = 0
    var y:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GenerateQuestion()

        val onClickListener: Any = gennew.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                GenerateQuestion()
            }
        })
        submit.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                intent = Intent(this@MainActivity, Activity2::class.java).apply {
                    putExtra("You", answertxt.text.toString().toInt())
                    putExtra("Correct", (x + y).toInt())
                }
                startActivity(intent)
            }
        })
    }
    fun GenerateQuestion(){
        x = (0..100).random()
        y = (0..100).random()
        questiontxt.text = x.toString() + " + " + y.toString() + " = "
        answertxt.text = null

    }
}