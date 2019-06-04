package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

public class IndicativeUserMeal {

    private final LocalDateTime mealIntakeDateTime;

    private final String mealDescription;

    private final int calories;

    private final boolean isDailyCalorieLimitBreached;

    public IndicativeUserMeal(LocalDateTime mealIntakeDateTime, String mealDescription, int calories, boolean isDailyCalorieLimitBreached) {
        this.mealIntakeDateTime = mealIntakeDateTime;
        this.mealDescription = mealDescription;
        this.calories = calories;
        this.isDailyCalorieLimitBreached = isDailyCalorieLimitBreached;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndicativeUserMeal that = (IndicativeUserMeal) o;

        if (calories != that.calories) return false;
        if (isDailyCalorieLimitBreached != that.isDailyCalorieLimitBreached) return false;
        if (!mealIntakeDateTime.equals(that.mealIntakeDateTime)) return false;
        return mealDescription.equals(that.mealDescription);

    }

    @Override
    public int hashCode() {
        int result = mealIntakeDateTime.hashCode();
        result = 31 * result + mealDescription.hashCode();
        result = 31 * result + calories;
        result = 31 * result + (isDailyCalorieLimitBreached ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IndicativeUserMeal{" +
                "mealIntakeDateTime=" + mealIntakeDateTime +
                ", mealDescription='" + mealDescription + '\'' +
                ", calories=" + calories +
                ", isDailyCalorieLimitBreached=" + isDailyCalorieLimitBreached +
                '}';
    }
}
