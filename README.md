# Hava Durumu API'si

Bu proje, Spring Boot ve RestTemplate kullanarak hava durumu bilgilerini almak için bir RESTful API sağlar. OpenWeatherMap API'si kullanılarak belirli bir şehrin günlük hava durumu, haftalık tahminler ve aylık tahminler gibi bilgileri alabilirsiniz. (Benim kullandığım key ücretsiz versiyon olduğundan yalnızca 5 günlük verileri çekebiliyorum.)

## Kullanılan Teknolojiler

- Spring Boot: Java tabanlı bir framework, RESTful web servisleri oluşturmak için kullanıldı.
- RestTemplate: Spring tarafından sağlanan HTTP istemci kütüphanesi, harici API'lerle iletişim kurmak için kullanıldı.
- OpenWeatherMap API: Hava durumu verilerini sağlamak için kullanıldı.

## Proje Yapısı

Proje, temel olarak Spring Boot uygulamasıdır. Ana bileşenler şunlardır:

- `WeatherController`: Spring Boot uygulamasının ana sınıfıdır. API endpoint'lerini tanımlar.
- `WeatherForecast`: OpenWeatherMap API'den gelen yanıtı temsil eden sınıftır.
- `DailyWeather`: API tarafından döndürülecek hava durumu bilgilerini temsil eden sınıf.
- `MainWeather`: Hava durumu tahminlerindeki temel verileri temsil eden sınıftır.

## Nasıl Kullanılır?

1. Proje dosyalarını bilgisayarınıza kopyalayın.
2. OpenWeatherMap API anahtarınızı ayarlayın.
3. Projeyi bir IDE'de veya terminalde çalıştırın.
4. API'ye HTTP istekleri göndererek hava durumu bilgilerini alın.

## API Endpoint'leri

- `/weather?city=Ankara&day=3`: Belirli bir şehrin istenilen günlük hava durumu bilgilerini alır.

## OpenWeatherMap API Anahtarını Alın

Proje OpenWeatherMap API'sini kullanır. Kendi API anahtarınızı almak için [OpenWeatherMap web sitesi](https://home.openweathermap.org/)ne kaydolmanız gerekmektedir.

