package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

public class UserMeal {

    private final LocalDateTime mealIntakeDateTime;

    private final String mealDescription;

    private final int calories;

    public UserMeal(LocalDateTime mealIntakeDateTime, String mealDescription, int calories) {
        this.mealIntakeDateTime = mealIntakeDateTime;
        this.mealDescription = mealDescription;
        this.calories = calories;
    }

    public LocalDateTime getMealIntakeDateTime() {
        return mealIntakeDateTime;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public int getCalories() {
        return calories;
    }
}
