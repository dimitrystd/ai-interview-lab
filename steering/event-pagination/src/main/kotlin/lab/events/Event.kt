package lab.events

import java.time.Instant

data class Event(val id: Long, val createdAt: Instant, val type: String)
