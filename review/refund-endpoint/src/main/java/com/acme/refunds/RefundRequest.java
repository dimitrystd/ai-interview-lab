package com.acme.refunds;

import java.math.BigDecimal;

public record RefundRequest(BigDecimal amount, String cardToken) {
}
