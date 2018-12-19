package com.example.enpit_p31.helloandroid

import android.app.Application
import io.realm.Realm

class MSA : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}