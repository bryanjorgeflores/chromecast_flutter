package it.aesys.flutter_cast_video

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding

/** FlutterVideoCastPlugin */
class FlutterVideoCastPlugin : FlutterPlugin, ActivityAware {
    private lateinit var chromeCastFactory: ChromeCastFactory
    private lateinit var flutterPluginBinding: FlutterPlugin.FlutterPluginBinding

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        this.flutterPluginBinding = flutterPluginBinding
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        // Limpia recursos si es necesario
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        chromeCastFactory = ChromeCastFactory(flutterPluginBinding.binaryMessenger, binding.activity)
        flutterPluginBinding.platformViewRegistry.registerViewFactory("ChromeCastButton", chromeCastFactory)
    }

    override fun onDetachedFromActivityForConfigChanges() {
        // No need to do anything here, as the factory is re-created in onReattachedToActivityForConfigChanges
    }

    override fun onDetachedFromActivity() {
        // No need to do anything here, as the factory is re-created in onAttachedToActivity
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        chromeCastFactory = ChromeCastFactory(flutterPluginBinding.binaryMessenger, binding.activity)
        flutterPluginBinding.platformViewRegistry.registerViewFactory("ChromeCastButton", chromeCastFactory)
    }
}