package com.acme.refunds.util; 

import java.util.Base64; 
import java.nio.charset.StandardCharsets; 

public final class Util09 { 

    private Util09() { 
    } 

    public static String encode(String value) { 
        return Base64.getUrlEncoder().withoutPadding() 
                .encodeToString(value.getBytes(StandardCharsets.UTF_8)); 
    } 
} 
