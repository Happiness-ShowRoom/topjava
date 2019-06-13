package ru.javawebinar.topjava.dao;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.web.MealServlet;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealList {

    private static final Logger log = getLogger(MealServlet.class);

    private static List<Meal> mealList;

    public static List<Meal> getMealList() {

        if(mealList == null) {


            mealList = new ArrayList<>(Arrays.asList(
                    new Meal(LocalDateTime.of(2019, Month.JUNE, 12, 9, 0, 0), "Salad", 500),
                    new Meal(LocalDateTime.of(2019, Month.JUNE, 12, 13, 0, 0), "Chips and salsa", 800),
                    new Meal(LocalDateTime.of(2019, Month.JUNE, 12, 22, 0, 0), "Coffee and mozzarella sticks", 800)
            ));
            log.debug("returning newly constructed meal list " + mealList);
            return mealList;
        }
        log.debug("returning previously constructed meal list " + mealList);
        return mealList;
    }
}
