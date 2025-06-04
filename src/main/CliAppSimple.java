package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;

import static main.InputUtils.*;

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

                System.out.println("Please enter your weight in kg:");
                int weight = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkNegativeNumber(weight)) {
                    System.err.println("Not a valid weight — cannot be negative");
                    continue;
                }

                System.out.println("Please enter your height in cm:");
                int height = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (height < 120) {
                    System.err.println("Not a valid height — must be at least 120 cm tall");
                    continue;
                }

                System.out.println("Please enter your birth year:");
                int birthYear = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkNegativeNumber(birthYear) || birthYear > Year.now().getValue()) {
                    System.err.println("Not a valid birth year — cannot be negative or in the future");
                    continue;
                }

                isValid = true;
                bufferedReader.close();

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
}