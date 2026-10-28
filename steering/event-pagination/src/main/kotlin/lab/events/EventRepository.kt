package lab.events

class EventRepository(events: List<Event>) {

    private val ordered = events.sortedWith(compareBy<Event> { it.createdAt }.thenBy { it.id })

    fun findAfter(afterMillis: Long?, limit: Int): List<Event> =
        ordered
            .filter { afterMillis == null || it.createdAt.toEpochMilli() > afterMillis }
            .take(limit)
}
