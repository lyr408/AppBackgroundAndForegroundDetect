package com.lyr.appdetect

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Context
import android.os.Bundle

/**
 * @author Yuanrui Liang
 * @version 1.0
 * @since 2019/5/9
 */
class AppActivityLifecycleCallbacks(private val mContext: Context) : ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {}
    override fun onActivityStarted(activity: Activity) {
        mContext.contentResolver.call(
            AppLifecycleProvider.Companion.URI,
            AppLifecycleProvider.Companion.OPERATE_START,
            null,
            null
        )
    }

    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {
        mContext.contentResolver.call(
            AppLifecycleProvider.Companion.URI,
            AppLifecycleProvider.Companion.OPERATE_STOP,
            null,
            null
        )
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
}