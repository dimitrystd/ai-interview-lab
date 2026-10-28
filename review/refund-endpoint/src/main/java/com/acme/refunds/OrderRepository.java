package com.acme.refunds;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Order> findByIdAndCustomerId(long id, long customerId);

    List<Order> findByCustomerIdOrderByCreatedAtDesc(long customerId);
}
