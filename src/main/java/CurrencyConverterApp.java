// CurrencyConverterApp.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CurrencyConverterApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Conversor de Moedas");
        ComboBox<String> currencyFrom = new ComboBox<>();
        ComboBox<String> currencyTo = new ComboBox<>();
        TextField amountField = new TextField();
        Button convertButton = new Button("Converter");
        Label resultLabel = new Label();

        currencyFrom.getItems().addAll("USD", "BRL", "EUR");
        currencyTo.getItems().addAll("USD", "BRL", "EUR");

        convertButton.setOnAction(e -> {
            try {
                String from = currencyFrom.getValue();
                String to = currencyTo.getValue();
                double amount = Double.parseDouble(amountField.getText());
                double rate = CurrencyConverter.getConversionRate(from, to);
                resultLabel.setText(String.format("Resultado: %.2f %s", amount * rate, to));
            } catch (Exception ex) {
                resultLabel.setText("Erro na conversão: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, label, currencyFrom, currencyTo, amountField, convertButton, resultLabel);
        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Conversor de Moedas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
