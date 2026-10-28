package com.acme.refunds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefundController {

    private static final Logger log = LoggerFactory.getLogger(RefundController.class);

    private final RefundService refunds;

    public RefundController(RefundService refunds) {
        this.refunds = refunds;
    }

    @PostMapping("/orders/{orderId}/refund")
    public ResponseEntity<Void> refund(@PathVariable long orderId,
                                       @RequestBody RefundRequest body) {
        try {
            refunds.refund(orderId, body.amount());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.warn("Refund failed: order={} card={}",
                    orderId, body.cardToken(), e);
            return ResponseEntity.ok().build();
        }
    }
}
