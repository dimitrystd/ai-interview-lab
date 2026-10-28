package com.acme.refunds.util; 

import java.util.function.Supplier; 
import java.util.concurrent.atomic.AtomicLong; 

public final class Util19 { 

    private Util19() { 
    } 

    public static Supplier<Long> sequence(long start) { 
        AtomicLong next = new AtomicLong(start); 
        return next::getAndIncrement; 
    } 
} 
