package io.daio.metrics

import android.util.Log
import com.fullstory.FS

object Metrics {

    fun intialise() {
        FS.setReadyListener {
            Log.d("Metrics", "Fullstory Initialised")
        }
    }
}