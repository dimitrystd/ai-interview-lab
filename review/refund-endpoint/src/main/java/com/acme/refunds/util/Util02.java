package com.acme.refunds.util; 

import java.util.Objects; 
import java.math.RoundingMode; 
import java.math.BigDecimal; 

public final class Util02 { 

    private Util02() { 
    } 

    public static BigDecimal roundMoney(BigDecimal amount) { 
        Objects.requireNonNull(amount); 
        return amount.setScale(2, RoundingMode.HALF_UP); 
    } 
} 
