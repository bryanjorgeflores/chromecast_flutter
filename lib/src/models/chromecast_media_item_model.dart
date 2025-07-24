class ChromecastMediaItemModel {
  final String url;
  final String title;
  final String subtitle;
  final String image;
  final String? contentType;

  ChromecastMediaItemModel({
    required this.url,
    required this.title,
    required this.subtitle,
    required this.image,
    this.contentType,
  });

  Map<String, dynamic> toJson() => <String, dynamic>{
        'url': url,
        'title': title,
        'subtitle': subtitle,
        'image': image,
        'contentType': contentType,
      };
}
