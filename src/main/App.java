package main;

public class App {
    public static void main(String[] args) {
        try {
            Person person = new Person("Lars", Sex.MALE, 90, 190, 1999);
            Calculator calculator = new CaloriesCalculator();
            person.setDailyCalories(calculator.calculate(person));
            System.out.println(String.format("%s, your daily calories are %.2f calories.", person.getName(), person.getDailyCalories()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}