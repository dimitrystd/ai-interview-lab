package com.acme.refunds.util; 

import java.util.StringJoiner; 
import java.util.Collection; 

public final class Util25 { 

    private Util25() { 
    } 

    public static String bracketed(Collection<String> values) { 
        StringJoiner joiner = new StringJoiner(", ", "[", "]"); 
        values.forEach(joiner::add); 
        return joiner.toString(); 
    } 
} 
