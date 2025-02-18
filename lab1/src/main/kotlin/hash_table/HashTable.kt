package itmo.tpo.hash_table


class HashTable<K, V : Comparable<V>>(private val size: Int = 20) {
    private val table: Array<MutableList<Pair<K, V>>?> = arrayOfNulls(size)

    fun put(key: K, value: V) {
        val keyHash = hash(key)

        if (table[keyHash] == null) {
            table[keyHash] = mutableListOf(Pair(key, value))
        } else {
            table[keyHash]
                ?.binarySearch { it.second.compareTo(value) }
                ?.let { table[keyHash]?.add(-(it + 1), Pair(key, value)) }
        }
    }

    fun get(key: K): V? {
        val keyHash = hash(key)

        return table[keyHash]
                    ?.find { it.first == key }
                    ?.second
    }

    fun remove(key: K) {
        val keyHash = hash(key)

        table[keyHash]
            ?.find { it.first == key }
            ?.let { table[keyHash]?.remove(it) }
    }

    private fun hash(value: K): Int {
        return value.hashCode() % this.size
    }

    override fun toString(): String {
        return StringBuilder().apply {
            table.forEach { list  -> list?.forEach { append("${it.first} to ${it.second}\n") } }
        }.toString()
    }
}