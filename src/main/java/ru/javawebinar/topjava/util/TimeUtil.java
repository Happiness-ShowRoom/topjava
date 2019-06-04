package ru.javawebinar.topjava.util;

import java.time.LocalTime;

public class TimeUtil {

    /**
     * This method indicates if the specified time falls in between the start and the end time parameters.
     * @param lt
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isTimeBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }
}
