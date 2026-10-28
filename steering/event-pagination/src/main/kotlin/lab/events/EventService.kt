package lab.events

import org.springframework.stereotype.Service

data class EventPage(val items: List<Event>, val nextCursor: String?)

@Service
class EventService(private val repo: EventRepository) {

    fun list(after: String?, limit: Int): EventPage {
        val items = repo.findAfter(after?.toLong(), limit)
        val next = if (items.size == limit) items.last().createdAt.toEpochMilli().toString() else null
        return EventPage(items, next)
    }
}
