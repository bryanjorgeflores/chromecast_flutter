import Flutter
import UIKit
import GoogleCast

@main
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
    GeneratedPluginRegistrant.register(with: self)
    let criteria = GCKDiscoveryCriteria(applicationID: "CC1AD845")
    let options = GCKCastOptions(discoveryCriteria: criteria)
    GCKCastContext.setSharedInstanceWith(options)
    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
}
