# SUP-231: Page 2 skips items in the events feed

Consumers report that page 2 of the feed skips items. A full read of a 25-event feed returns 23 events.

Repro: `./gradlew test --tests "lab.events.EventServiceTest.pagesTogetherContainEveryEvent"`

```
WARN  EventsClient  fetchAll(limit=10) expected 25 got 23
expected: 25 but was: 23
```

From the team channel:
> The docs say page and size. The cursor code looks like leftover from an old prototype.

Acceptance: the test above is green and nothing else regresses.
