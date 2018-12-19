package com.example.enpit_p31.helloandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_asae.*
import kotlinx.android.synthetic.main.activity_namae_edit.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

class NamaeEditActivity : AppCompatActivity() {
    private  lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_namae_edit)
        realm = Realm.getDefaultInstance()

        val ASAId = intent?.getLongExtra("ASA_id", -1L)
        if (ASAId != -1L) {
            val ASA = realm.where<Model>()
                    .equalTo("id", ASAId).findFirst()
            namaeEdit.setText(ASA?.namae)
            asa2Edit.setText(ASA?.asa1)
            deleteASA.visibility = View.VISIBLE
        }else{
            deleteASA.visibility = View.INVISIBLE
        }

        savenamaebutton.setOnClickListener {
            when (ASAId) {
                -1L ->{
                    realm.executeTransaction {
                        val maxIdasa = realm.where<Model>().max("id")
                        val nextIdasa = (maxIdasa?.toLong() ?: 0L) + 1
                        val scheduleasa = realm.createObject<Model>(nextIdasa)
                        scheduleasa.namae = namae2Edit.text.toString()
                    }
                    alert("追加しました") {
                        yesButton { finish() }
                    }.show()
                }
                else -> {
                    realm.executeTransaction {
                        val scheduleasa = realm.where<Model>()
                                .equalTo("id", ASAId).findFirst()
                        scheduleasa?.namae = namae2Edit.text.toString()
                    }
                    alert("修正しました"){
                        yesButton { finish() }
                    }.show()
                }
            }
        }
        deletenamebutton.setOnClickListener {
            realm.executeTransaction {
                realm.where<Model>().equalTo("id", ASAId)?.findFirst()?.deleteFromRealm()
            }
            alert("削除しました") {
                yesButton { finish() }
            }.show()
        }
    }
}

