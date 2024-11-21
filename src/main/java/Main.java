// Main.java
public class Main {
    public static void main(String[] args) {
        if (AuthSystem.authenticate()) {
            CurrencyConverterApp.main(args);
        } else {
            System.out.println("Acesso negado.");
        }
    }
}
