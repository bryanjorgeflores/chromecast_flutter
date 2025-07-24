package com.example.flutter_cast_video_example

import io.flutter.embedding.android.FlutterFragmentActivity
import com.google.android.gms.cast.framework.CastContext
import android.os.Bundle

class MainActivity : FlutterFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CastContext.getSharedInstance(this)
    }
}

