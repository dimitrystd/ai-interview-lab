package com.acme.refunds.util; 

import java.util.HexFormat; 
import java.security.NoSuchAlgorithmException; 
import java.security.MessageDigest; 
import java.nio.charset.StandardCharsets; 

public final class Util10 { 

    private Util10() { 
    } 

    public static String sha256(String value) { 
        try { 
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
            return HexFormat.of().formatHex(digest.digest(value.getBytes(StandardCharsets.UTF_8))); 
        } catch (NoSuchAlgorithmException e) { 
            throw new IllegalStateException(e); 
        } 
    } 
} 
