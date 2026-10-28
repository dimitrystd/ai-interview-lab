package com.acme.refunds.util; 

import java.time.LocalDate; 
import java.time.DayOfWeek; 

public final class Util14 { 

    private Util14() { 
    } 

    public static boolean isWeekend(LocalDate date) { 
        DayOfWeek day = date.getDayOfWeek(); 
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY; 
    } 
} 
