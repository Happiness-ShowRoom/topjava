package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.IndicativeUserMeal;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static void main(String[] args) {

        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );

        getEnhancedFilteredMealList1(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
    }

    /**
     * This method filters a list of meals that fall into the specified timeframe
     * and returns a list of enhanced IndicativeUserMeal objects marked with a boolean
     * flag indicating the breach of the daily calorie intake limit for the particular day
     * (forEach and merge implementation).
     * @param mealList
     * @param startTime
     * @param endTime
     * @param caloriesPerDay
     * @return
     */
    public static List<IndicativeUserMeal> getEnhancedFilteredMealList1(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        final Map<LocalDate, Integer> dailyCalorieIntake = new HashMap<>();
        mealList.forEach(userMeal -> dailyCalorieIntake.merge(userMeal.getMealIntakeDateTime().toLocalDate(), userMeal.getCalories(), Integer::sum));

        final List<IndicativeUserMeal> filteredUserMeals = new ArrayList<>();
        mealList.forEach(userMeal -> {
            if (TimeUtil.isTimeBetween(userMeal.getMealIntakeDateTime().toLocalTime(), startTime, endTime)) {
                filteredUserMeals.add(new IndicativeUserMeal(userMeal.getMealIntakeDateTime(), userMeal.getMealDescription(), userMeal.getCalories(), dailyCalorieIntake.get(userMeal.getMealIntakeDateTime().toLocalDate()) > caloriesPerDay));
            }
        });
        return filteredUserMeals;
    }

    /**
     * This method filters a list of meals that fall into the specified timeframe
     * and returns a list of enhanced IndicativeUserMeal objects marked with a boolean
     * flag indicating the breach of the daily calorie intake limit for the particular day
     * (collect and filter implementation).
     * @param mealList
     * @param startTime
     * @param endTime
     * @param caloriesPerDay
     * @return
     */
    public static List<IndicativeUserMeal>  getEnhancedFilteredMealList2(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> dailyCalorieIntake = mealList.stream()
                .collect(Collectors.groupingBy(userMeal -> userMeal.getMealIntakeDateTime().toLocalDate(), Collectors.summingInt(UserMeal::getCalories)));

        return mealList.stream()
                .filter(userMeal -> TimeUtil.isTimeBetween(userMeal.getMealIntakeDateTime().toLocalTime(), startTime, endTime))
                .map(userMeal -> new IndicativeUserMeal(userMeal.getMealIntakeDateTime(), userMeal.getMealDescription(), userMeal.getCalories(), dailyCalorieIntake.get(userMeal.getMealIntakeDateTime().toLocalDate()) > caloriesPerDay)).collect(Collectors.toList());
    }
}
