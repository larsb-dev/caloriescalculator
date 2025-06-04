package main;

public class InputUtils {
    public static String formatString(String userInput) {
        return userInput.replaceAll("\\s+", "").trim();
    }

    public static boolean checkNegativeNumber(int userInput) {
        return userInput < 0;
    }
}