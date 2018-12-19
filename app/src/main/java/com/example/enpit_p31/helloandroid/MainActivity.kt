package com.example.enpit_p31.helloandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nyuryoku.setOnClickListener { onN(it) }
        namaebutton.setOnClickListener { onNamae(it) }
    }
    fun onN (view: View){
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }
    fun onNamae (view: View) {
        val intent = Intent(this, NamaeNyuuryokuEditActivity::class.java)
        startActivity(intent)
    }

}
