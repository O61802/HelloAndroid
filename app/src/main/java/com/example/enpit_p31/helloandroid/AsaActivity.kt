package com.example.enpit_p31.helloandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_asa.*
import org.jetbrains.anko.startActivity

class AsaActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asa)
        backASA.setOnClickListener { finish() }
        asagohan2.setOnClickListener { onASAGOHAN(it) }
        realm = Realm.getDefaultInstance()
        val ASA = realm.where<Model>().findAll()
        listViewAsa.adapter = AA(ASA)
        listViewAsa.setOnItemClickListener { parent, view, position, id ->
            val AASA = parent.getItemAtPosition(position) as Model
            startActivity<ASAEActivity>("ASA_id" to AASA.id)
        }
    }
    fun onASAGOHAN (view: View){
        val intent = Intent(this, ASAEActivity::class.java)
        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
