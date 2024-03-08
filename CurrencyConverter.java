import java.util.*;

public class CurrencyConverter {
    
    private Map<String, Double> exchangeRates; // a map to store exchange rates between currencies
    
    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // add exchange rates for five major countries including India
        exchangeRates.put("USD", 1.00); // US dollar
        exchangeRates.put("EUR", 0.82); // Euro
        exchangeRates.put("GBP", 0.72); // British pound
        exchangeRates.put("INR", 73.42); // Indian rupee
        exchangeRates.put("JPY", 109.66); // Japanese yen
    }
    
    public List<String> getAvailableCurrencies() {
        // return a list of available currencies
        return new ArrayList<>(exchangeRates.keySet());
    }
    
    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        double exchangeRate = toRate / fromRate;
        return amount * exchangeRate;
    }
    
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        List<String> currencies = converter.getAvailableCurrencies();
        System.out.println("Available currencies:");
        for (String currency : currencies) {
            System.out.println(currency);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter the amount: ");
        double amount = sc.nextDouble();
        System.out.println("Enter the currency from which you want to convert (in caps): ");
        String fromCurrency = sc.next();
        System.out.println("Enter the currency to which you want to convert (in caps): ");
        String toCurrency = sc.next();
        double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
        System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
    }
}