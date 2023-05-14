package com.kliachenko.vknewsclient.presentation

import android.app.Application
import com.kliachenko.vknewsclient.di.ApplicationComponent
import com.kliachenko.vknewsclient.di.DaggerApplicationComponent

class NewsFeedApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }


}