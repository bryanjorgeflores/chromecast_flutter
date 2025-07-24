#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint flutter_cast_video.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'flutter_cast_video'
  s.version          = '1.3.0'
  s.summary          = 'flutter_cast_video let you discover cast devices like Chrome Cast and Apple TV and connect to them.'
  s.description      = <<-DESC
flutter_cast_video let you discover cast devices like Chrome Cast and Apple TV and connect to them.
                       DESC
  s.homepage         = 'https://github.com/whowillcare/flutter_cast_video'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.dependency 'google-cast-sdk-no-bluetooth', '~> 4.8.0'
  s.platform = :ios, '12.0'
  s.static_framework = true

  # Flutter.framework does not contain a i386 slice. Only x86_64 simulators are supported.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'VALID_ARCHS[sdk=iphonesimulator*]' => 'x86_64', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'arm64'}
  s.user_target_xcconfig = { 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'arm64'}
  s.swift_version = '5.0'
end
