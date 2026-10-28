# SUP-212: Order totals are sometimes off by a cent

Support reports that some order totals show one cent less than the sum of the line prices.
A customer buying 100 units at 1.15 was shown 114.99 at checkout.

Reproduce: `./gradlew test --tests "lab.checkout.OrderServiceTest.totalIsExactForOneHundredUnitsAtOneFifteen"`

```
expected:<115.00> but was:<114.99>
```

Comment from a teammate:
> Looks like `OrderService` truncates instead of rounding. Probably needs HALF_UP.

Please get the named test passing. The rest of the suite must stay green.
