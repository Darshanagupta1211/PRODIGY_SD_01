import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit of measurement (Celsius, Fahrenheit, or Kelvin): ");
        String originalUnit = scanner.next();

        convertAndDisplay(temperature, originalUnit);
    }

    private static void convertAndDisplay(double temperature, String originalUnit) {
        double convertedCelsius = 0;
        double convertedFahrenheit = 0;
        double convertedKelvin = 0;

        switch (originalUnit.toLowerCase()) {
            case "celsius":
                convertedCelsius = temperature;
                convertedFahrenheit = celsiusToFahrenheit(temperature);
                convertedKelvin = celsiusToKelvin(temperature);
                break;
            case "fahrenheit":
                convertedCelsius = fahrenheitToCelsius(temperature);
                convertedFahrenheit = temperature;
                convertedKelvin = celsiusToKelvin(convertedCelsius);
                break;
            case "kelvin":
                convertedCelsius = kelvinToCelsius(temperature);
                convertedFahrenheit = celsiusToFahrenheit(convertedCelsius);
                convertedKelvin = temperature;
                break;
            default:
                System.out.println("Invalid unit of measurement. Please enter Celsius, Fahrenheit, or Kelvin.");
                return;
        }

        System.out.println("Converted temperatures:");
        System.out.println("Celsius: " + convertedCelsius + " °C");
        System.out.println("Fahrenheit: " + convertedFahrenheit + " °F");
        System.out.println("Kelvin: " + convertedKelvin + " K");
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}