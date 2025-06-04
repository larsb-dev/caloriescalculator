package main;

public class App {
    public static void main(String[] args) {
        try {
            Person person = new Person("Lars", Sex.MALE, 90, 190, 1999);
            Calculator calculator = new CaloriesCalculator();
            person.setDailyCalories(calculator.calculate(person));
            System.out.println(person);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.err.println("IllegalArgumentException: " + illegalArgumentException.getMessage());
        } catch (Exception exception) {
            System.err.println("Exception" + exception.getMessage());
        }
    }
}