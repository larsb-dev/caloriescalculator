package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;

public class CliAppSimple {
    public static void main(String[] args) throws IOException {
        boolean isValid = false;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.println("Please enter your name:");
                String name = formatString(bufferedReader.readLine());

                if (!name.matches("[A-Za-z]+")) {
                    System.err.println("Not a valid name — allowed letters: [A-Za-z]");
                    continue;
                }

                System.out.println("Please enter your sex: [male,female]");
                Sex sex = Sex.valueOf(formatString(bufferedReader.readLine()).toUpperCase());

                System.out.println("Please enter your weight:");
                int weight = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkNegativeNumber(weight)) {
                    System.err.println("Not a valid weight — cannot be negative");
                    continue;
                }

                System.out.println("Please enter your height:");
                int height = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkNegativeNumber(height)) {
                    System.err.println("Not a valid height — cannot be negative");
                    continue;
                }

                System.out.println("Please enter your birth year:");
                int birthYear = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkNegativeNumber(birthYear) || birthYear > Year.now().getValue()) {
                    System.err.println("Not a valid birth year — cannot be negative or in the future");
                    continue;
                }

                isValid = true;

                Person person = new Person(name, sex, weight, height, birthYear);
                Calculator calculator = new CaloriesCalculator();

                person.setDailyCalories(calculator.calculate(person));

                System.out.println(person);
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Not a valid number — " + numberFormatException.getMessage());
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("Not a valid argument — " + illegalArgumentException.getMessage());
            }
        } while (!isValid);
    }

    public static String formatString(String userInput) {
        return userInput.replaceAll("\\s+", "").trim();
    }

    public static boolean checkNegativeNumber(int userInput) {
        return userInput < 0;
    }
}