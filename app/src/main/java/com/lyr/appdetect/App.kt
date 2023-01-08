package com.lyr.appdetect

import android.app.Application

/**
 * @author Yuanrui Liang
 * @version 1.0
 * @since 2019/5/9
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(AppActivityLifecycleCallbacks(this))
    }
}