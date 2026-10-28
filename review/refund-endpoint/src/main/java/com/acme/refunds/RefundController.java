package com.acme.refunds;

import com.acme.security.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefundController {

    private final RefundService refunds;

    public RefundController(RefundService refunds) {
        this.refunds = refunds;
    }

    @PostMapping("/orders/{orderId}/refund")
    public ResponseEntity<Void> refund(@PathVariable long orderId,
                                       @AuthenticationPrincipal Customer customer) {
        refunds.refundInFull(orderId, customer.id());
        return ResponseEntity.ok().build();
    }
}
