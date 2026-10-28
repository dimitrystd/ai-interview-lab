package com.acme.refunds.util; 

import java.util.Objects; 
import java.util.List; 
import java.util.ArrayList; 

public final class Util03 { 

    private Util03() { 
    } 

    public static <T> List<T> copyOf(List<T> source) { 
        Objects.requireNonNull(source); 
        return new ArrayList<>(source); 
    } 
} 
