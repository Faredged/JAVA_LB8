import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

class WeatherData {
    private LocalDate date;
    private int stationId;
    private double temperature;
    private double humidity;
    private double precipitation;
    private double windSpeed;

    public WeatherData(LocalDate date, int stationId, double temperature, double humidity, double precipitation, double windSpeed) {
        this.date = date;
        this.stationId = stationId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
    }

    public int getStationId() {
        return stationId;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }
}

public class WeatherAnalysis {

    public static void main(String[] args) {
        List<WeatherData> weatherDataList = fetchDataFromAPI();

        List<WeatherData> hottestStations = findHottestStations(weatherDataList);
        List<WeatherData> coldestStations = findColdestStations(weatherDataList);
        List<WeatherData> rainiestStations = findRainiestStations(weatherDataList);

        displayResults("Hottest Stations", hottestStations);
        displayResults("Coldest Stations", coldestStations);
        displayResults("Rainiest Stations", rainiestStations);

        // Додайте інші завдання та обробку результатів за необхідністю.
    }

    public static List<WeatherData> fetchDataFromAPI() {
        // Реалізувати отримання даних з метеорологічного API.
        return new ArrayList<>(); // Приклад повертає пустий список.
    }

    public static List<WeatherData> findHottestStations(List<WeatherData> data) {
        // Реалізувати пошук 10 найгарячіших станцій за середньою температурою.
        return data.stream()
                .sorted((a, b) -> Double.compare(b.getTemperature(), a.getTemperature()))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<WeatherData> findColdestStations(List<WeatherData> data) {
        // Реалізувати пошук 10 найхолодніших станцій за середньою температурою.
        return data.stream()
                .sorted((a, b) -> Double.compare(a.getTemperature(), b.getTemperature()))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<WeatherData> findRainiestStations(List<WeatherData> data) {
        // Реалізувати пошук 10 найвологіших станцій за середнім рівнем опадів.
        return data.stream()
                .sorted((a, b) -> Double.compare(b.getPrecipitation(), a.getPrecipitation()))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static void displayResults(String title, List<WeatherData> stations) {
        System.out.println(title + ":");
        for (WeatherData data : stations) {
            System.out.println("Station ID: " + data.getStationId() + ", Temperature: " + data.getTemperature());
        }
        System.out.println();
    }
}
