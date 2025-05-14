package it.aesys.flutter_cast_video

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding

/** FlutterVideoCastPlugin */
class FlutterVideoCastPlugin : FlutterPlugin, ActivityAware {
    private lateinit var chromeCastFactory: ChromeCastFactory

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        chromeCastFactory = ChromeCastFactory(flutterPluginBinding.binaryMessenger)
        flutterPluginBinding
            .platformViewRegistry
            .registerViewFactory(
                "ChromeCastButton",
                chromeCastFactory
            )
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        // Limpia recursos si es necesario
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        chromeCastFactory.activity = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {
        chromeCastFactory.activity = null
    }

    override fun onDetachedFromActivity() {
        chromeCastFactory.activity = null
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        chromeCastFactory.activity = binding.activity
    }
}