import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// Step 1: Create a class to represent the Currency Converter
class CurrencyConverter {
    private String baseCurrency;
    private String targetCurrency;
    private double exchangeRate;

    public CurrencyConverter(String baseCurrency, String targetCurrency) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        fetchExchangeRate();
    }

    private void fetchExchangeRate() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.exchangerate-api.com/v4/latest/" + baseCurrency))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            exchangeRate = getExchangeRateFromResponse(responseBody, targetCurrency);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error fetching exchange rate: " + e.getMessage());
        }
    }

    private double getExchangeRateFromResponse(String responseBody, String targetCurrency) {
        // Parse the JSON response to extract the exchange rate
        // For simplicity, assume the response is in the format:
        // {"rates":{"<targetCurrency>":<exchangeRate>}}
        int startIndex = responseBody.indexOf("\"" + targetCurrency + "\"") + targetCurrency.length() + 3;
        int endIndex = responseBody.indexOf(",", startIndex);
        String exchangeRateStr = responseBody.substring(startIndex, endIndex);
        return Double.parseDouble(exchangeRateStr);
    }

    public double convertAmount(double amount) {
        return amount * exchangeRate;
    }
}

// Step 2: Create a class to represent the User Interface
class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Currency Converter:");
        System.out.println("1. Convert Currency");
        System.out.println("2. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                convertCurrency();
            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void convertCurrency() {
        System.out.print("Enter base currency (e.g. USD, EUR, JPY): ");
        String baseCurrency = scanner.next();
        System.out.print("Enter target currency (e.g. USD, EUR, JPY): ");
        String targetCurrency = scanner.next();
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        CurrencyConverter converter = new CurrencyConverter(baseCurrency, targetCurrency);
        double convertedAmount = converter.convertAmount(amount);

        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
    }
}

// Step 3: Create an instance of the User Interface and run it
public class curencyc{
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}
