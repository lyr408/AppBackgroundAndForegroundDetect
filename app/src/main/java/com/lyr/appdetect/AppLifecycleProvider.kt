package com.lyr.appdetect

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log

/**
 * @author Yuanrui Liang
 * @version 1.0
 * @since 2019/5/9
 */
class AppLifecycleProvider : ContentProvider() {
    private var activityCount = 0

    init {
        Log.d(TAG, "AppListenerProvider: ")
    }

    override fun getType(uri: Uri): String? {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        // TODO: Implement this to handle requests to insert a new row.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate(): Boolean {
        // TODO: Implement this to initialize your content provider on startup.
        Log.d(TAG, "onCreate: ")
        return false
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        // TODO: Implement this to handle query requests from clients.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        // TODO: Implement this to handle requests to update one or more rows.
        activityCount = values!!.getAsInteger(KEY_ACTIVITY_COUNT)
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        // Implement this to handle requests to delete one or more rows.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun call(method: String, arg: String?, extras: Bundle?): Bundle? {
        if (method == OPERATE_START) {
            ++activityCount
        } else if (method == OPERATE_STOP) {
            --activityCount
        } else if (method == OPERATE_QUERY) {
            extras?.putBoolean(
                IS_FOREGROUND,
                activityCount > BACKGROUND
            )
        }
        return extras
    }

    companion object {
        const val FOREGROUND = 1
        const val BACKGROUND = 0
        private const val TAG = "AppListenerProvider"
        val URI = Uri.parse("content://com.lyr.app.lifecycle")
        const val KEY_ACTIVITY_COUNT = "KEY_ACTIVITY_COUNT"
        const val OPERATE_START = "operate_start"
        const val OPERATE_STOP = "operate_stop"
        const val OPERATE_QUERY = "operate_query"
        const val IS_FOREGROUND = "status"
    }
}