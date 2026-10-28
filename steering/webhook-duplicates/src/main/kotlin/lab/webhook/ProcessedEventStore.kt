package lab.webhook

import java.util.concurrent.ConcurrentHashMap

interface ProcessedEventStore {
    fun exists(id: String): Boolean
    fun markProcessed(id: String)
}

class InMemoryProcessedEventStore : ProcessedEventStore {

    private val ids = ConcurrentHashMap.newKeySet<String>()

    override fun exists(id: String): Boolean = id in ids

    override fun markProcessed(id: String) {
        ids.add(id)
    }
}
