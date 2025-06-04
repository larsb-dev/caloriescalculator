package main;

import java.time.Year;

import static main.InputUtils.checkNegativeNumber;

public class Person {
    private String name = "";
    private Sex sex = Sex.MALE;
    private int weight = 0;
    private int height = 0;
    private int birthYear = 0;
    private int age = 0;
    private double dailyCalories = 0;
    private ActivityLevel activityLevel = ActivityLevel.MODERATELY_ACTIVE;

    public Person(String name, Sex sex, int weight, int height, int birthYear) {
        if (checkNegativeNumber(birthYear) || birthYear > Year.now().getValue()) {
            throw new IllegalArgumentException("Not a valid birth year — cannot be negative or in the future");
        }
        if (height < 120) {
            throw new IllegalArgumentException("Not a valid height — must be at least 120 cm tall");
        }

        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.birthYear = birthYear;

        calcAge(birthYear);
    }

    private void calcAge(int birthYear) {
        int currentYear = Year.now().getValue();
        age = currentYear - birthYear;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public double getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(double dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", weight=" + weight +
                ", height=" + height +
                ", birthYear=" + birthYear +
                ", age=" + age +
                ", dailyCalories=" + dailyCalories +
                ", activityLevel=" + activityLevel +
                '}';
    }
}