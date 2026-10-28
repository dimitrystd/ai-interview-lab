package lab.events.client

import lab.events.Event
import lab.events.EventService

class EventsClient(private val service: EventService) {

    fun fetchAll(limit: Int): List<Event> {
        val all = mutableListOf<Event>()
        var cursor: String? = null
        do {
            val page = service.list(cursor, limit)
            all += page.items
            cursor = page.nextCursor
        } while (cursor != null)
        return all
    }
}
