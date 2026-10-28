package com.acme.refunds.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public final class Util14 {

    private Util14() {
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
