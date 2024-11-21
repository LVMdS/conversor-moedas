// AuthSystem.java
import java.util.HashMap;
import java.util.Scanner;

public class AuthSystem {

    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("admin", "1234");
        users.put("user", "password");
    }

    public static boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o usuário:");
        String username = scanner.nextLine();
        System.out.println("Digite a senha:");
        String password = scanner.nextLine();

        return users.containsKey(username) && users.get(username).equals(password);
    }
}
