package com.example.enpit_p31.helloandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_namae_nyuuryoku_edit.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

class NamaeNyuuryokuEditActivity : AppCompatActivity() {
    private  lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_namae_nyuuryoku_edit)
        realm = Realm.getDefaultInstance()

        val ASAId = intent?.getLongExtra("ASA_id", -1L)
        if (ASAId != -1L) {
            val ASA = realm.where<Model>()
                    .equalTo("id", ASAId).findFirst()
            namaetourokuEdit.setText(ASA?.namae)

            deletenamaebutton.visibility = View.VISIBLE
        }else{
            deletenamaebutton.visibility = View.INVISIBLE
        }

        savenamaebutton.setOnClickListener {
            when (ASAId) {
                -1L ->{
                    realm.executeTransaction {
                        val maxIdasa = realm.where<Model>().max("id")
                        val nextIdasa = (maxIdasa?.toLong() ?: 0L) + 1
                        val scheduleasa = realm.createObject<Model>(nextIdasa)
                        scheduleasa.namae = namaetourokuEdit.text.toString()
                    }
                    alert("追加しました") {
                        yesButton { finish() }
                    }.show()
                }
                else -> {
                    realm.executeTransaction {
                        val scheduleasa = realm.where<Model>()
                                .equalTo("id", ASAId).findFirst()
                        scheduleasa?.namae = namaetourokuEdit.text.toString()
                    }
                    alert("修正しました"){
                        yesButton { finish() }
                    }.show()
                }
            }
        }
        deletenamaebutton.setOnClickListener {
            realm.executeTransaction {
                realm.where<Model>().equalTo("id", ASAId)?.findFirst()?.deleteFromRealm()
            }
            alert("削除しました") {
                yesButton { finish() }
            }.show()
        }
    }
}
