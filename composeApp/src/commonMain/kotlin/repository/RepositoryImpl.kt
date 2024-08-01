package repository

import domain.IRepository
import entity.Payments

class RepositoryImpl(
    private val cacheData: ICacheData
) : IRepository {
    override suspend fun getAllPayments(): List<Payments> = cacheData.getAllPayments()
    override suspend fun insertPayment(payments: Payments) = cacheData.insertPayment(payments)
}