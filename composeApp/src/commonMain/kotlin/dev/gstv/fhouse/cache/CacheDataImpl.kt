package dev.gstv.fhouse.cache

import dev.gstv.fhouse.DatabaseHelper
import entity.Payments
import repository.ICacheData

class CacheDataImpl(
    private val database: DatabaseHelper
) : ICacheData {
    override suspend fun getAllPayments(): List<Payments> {
        return database.getAllTest().map { Payments(it.id, it.name, it.description, it.date, it.value) }
    }

    override suspend fun insertPayment(payments: Payments) {
        database.insertPayment(payments)
    }
}