package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens.classes.firebase

import android.app.Application

typealias FB = MyFirebase
class MyFirebase {
    companion object {

        lateinit var analytics: MyFirebaseAnalytics
        val crashlytics = MyFirebaseCrashlytics()
        lateinit var auth: MyFirebaseAuth
        val db = MyFirebaseDatabase()
        val storage = MyFirebaseStorage()
        fun init(appContext: Application) {
            analytics = MyFirebaseAnalytics(appContext)
            auth = MyFirebaseAuth(appContext)
        }
    }
}
