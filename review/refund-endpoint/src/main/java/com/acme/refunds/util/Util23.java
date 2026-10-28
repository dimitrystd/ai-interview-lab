package com.acme.refunds.util; 

import java.util.List; 
import java.util.Comparator; 
import java.time.Instant; 

public final class Util23 { 

    private Util23() { 
    } 

    public static List<Instant> newestFirst(List<Instant> values) { 
        return values.stream().sorted(Comparator.reverseOrder()).toList(); 
    } 
} 
