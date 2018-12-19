package com.example.enpit_p31.helloandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_syokuzi.*

class SyokuziActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syokuzi)
        backSyokuzi.setOnClickListener { finish() }
        asagohan2.setOnClickListener { onAsa(it) }
    }
    fun onAsa (view: View) {
        val intent = Intent(this, AsaActivity::class.java)
        startActivity(intent)
    }
}
