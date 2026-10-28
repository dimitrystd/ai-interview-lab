package com.acme.refunds.util; 

import java.time.YearMonth; 
import java.time.LocalDate; 

public final class Util21 { 

    private Util21() { 
    } 

    public static LocalDate endOfMonth(LocalDate date) { 
        return YearMonth.from(date).atEndOfMonth(); 
    } 
} 
