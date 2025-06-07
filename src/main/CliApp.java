package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static main.InputUtils.*;

public class CliApp {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CaloriesCalculator caloriesCalculator = new CaloriesCalculator();

        try {

            String name;

            while (true) {
                System.out.println("Please enter your name:");
                name = formatString(bufferedReader.readLine());

                if (checkName(name)) {
                    break;
                } else {
                    System.err.println("Not a valid name — allowed letters: [A-Za-z]");
                }
            }

            Sex sex;

            while (true) {
                System.out.println("Please enter your sex: [male,female]");
                try {
                    sex = Sex.valueOf(formatString(bufferedReader.readLine()).toUpperCase());
                    if (checkSex(sex)) {
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Not a valid sex — allowed sexes: male or female");
                }
            }

            int weight;

            while (true) {
                System.out.println("Please enter your weight in kg:");
                weight = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkPositiveNumber(weight)) {
                    break;
                } else {
                    System.err.println("Not a valid weight — cannot be negative");
                }
            }

            int height;

            while (true) {
                System.out.println("Please enter your height in cm:");
                height = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkHeight(height)) {
                    break;
                } else {
                    System.err.println("Not a valid height — must be at least 120 cm tall");
                }
            }

            int birthYear;

            while (true) {
                System.out.println("Please enter your birth year:");
                birthYear = Integer.parseInt(formatString(bufferedReader.readLine()));

                if (checkBirthYear(birthYear)) {
                    break;
                } else {
                    System.err.println("Not a valid birth year — cannot be more more than 100 years old or in the future");
                }
            }

            bufferedReader.close();

            Person person = new Person(name, sex, weight, height, birthYear);
            person.setDailyCalories(caloriesCalculator.calculate(person));

            System.out.println(person);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}