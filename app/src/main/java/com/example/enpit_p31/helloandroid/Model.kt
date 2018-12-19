package com.example.enpit_p31.helloandroid

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Model : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var namae: String = ""
    var asa1: String = ""
}