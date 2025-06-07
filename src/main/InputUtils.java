package main;

import java.time.Year;

public class InputUtils {
    public static String formatString(String userInput) {
        return userInput.replaceAll("\\s+", "").trim();
    }

    public static boolean checkName(String userInput) {
        return userInput.matches("[A-Za-z]+");
    }

    public static boolean checkSex(Sex userInput) {
        return userInput == Sex.MALE || userInput == Sex.FEMALE;
    }

    public static boolean checkPositiveNumber(int userInput) {
        return userInput > 0;
    }

    public static boolean checkHeight(int userInput) {
        return userInput >= 120;
    }

    public static boolean checkBirthYear(int userInput) {
        return userInput >= Year.now().getValue() - 100 && userInput <= Year.now().getValue();
    }
}