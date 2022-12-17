package com.lyr.appdetect

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lyr.appdetect.NewProcessActivity

/**
 * @author Yuanrui Liang
 * @version 1.0
 * @since 2019/5/9
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.button).setOnClickListener { view: View? ->
            val intent = Intent(this@MainActivity, NewProcessActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        var bundle = Bundle()
        bundle = contentResolver.call(
            AppLifecycleProvider.URI,
            AppLifecycleProvider.OPERATE_QUERY,
            "MainActivity",
            bundle
        )!!
        Log.d(TAG, "onStop: " + bundle.getBoolean(AppLifecycleProvider.Companion.IS_FOREGROUND))
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}