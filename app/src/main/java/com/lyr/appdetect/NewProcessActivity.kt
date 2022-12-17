package com.lyr.appdetect

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Yuanrui Liang
 * @version 1.0
 * @since 2019/5/9
 */
class NewProcessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_process)
        var bundle = Bundle()
        bundle = contentResolver.call(
            AppLifecycleProvider.URI,
            AppLifecycleProvider.OPERATE_QUERY,
            "NewProcessActivity",
            bundle
        )!!
        Log.d(TAG, "onCreate: " + bundle.getBoolean(AppLifecycleProvider.Companion.IS_FOREGROUND))
    }

    companion object {
        private const val TAG = "NewProcessActivity"
    }
}