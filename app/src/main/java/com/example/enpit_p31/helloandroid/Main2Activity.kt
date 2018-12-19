package com.example.enpit_p31.helloandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        backMain2.setOnClickListener { finish() }
        syokuzi.setOnClickListener { onS(it) }
    }

    fun onS (view: View){
        val intent = Intent(this, SyokuziActivity::class.java)
        startActivity(intent)
    }
}
