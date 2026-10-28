package com.acme.refunds.util; 

import java.util.Locale; 
import java.text.NumberFormat; 
import java.math.BigDecimal; 

public final class Util16 { 

    private Util16() { 
    } 

    public static String formatMoney(BigDecimal amount) { 
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount); 
    } 
} 
