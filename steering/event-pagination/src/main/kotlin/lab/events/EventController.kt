package lab.events

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(private val service: EventService) {

    @GetMapping("/events")
    fun events(
        @RequestParam(required = false) cursor: String?,
        @RequestParam(defaultValue = "10") limit: Int,
    ): EventPage = service.list(cursor, limit)
}
