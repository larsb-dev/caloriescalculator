package main;

public class CaloriesCalculator implements Calculator {
    @Override
    public double calculate(Person person) {
        double bmr;
        if (person.getSex() == Sex.MALE) {
            bmr = 10 * person.getWeight() + 6.25 * person.getHeight() - 5 * person.getAge() + 5;
        } else {
            bmr = 10 * person.getWeight() + 6.25 * person.getHeight() - 5 * person.getAge() - 161;;
        }

        double activityFactor = person.getActivityLevel().getMultiplier();

        return bmr * activityFactor;
    }
}