package com.acme.refunds.util; 

import java.time.ZoneOffset; 
import java.time.LocalDate; 
import java.time.Instant; 

public final class Util04 { 

    private Util04() { 
    } 

    public static LocalDate toDate(Instant instant) { 
        return instant.atOffset(ZoneOffset.UTC).toLocalDate(); 
    } 
} 
