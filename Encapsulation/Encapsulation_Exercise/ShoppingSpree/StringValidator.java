package ShoppingSpree;

public class StringValidator {

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
