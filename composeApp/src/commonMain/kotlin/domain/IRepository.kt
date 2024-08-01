package domain

import entity.Payments

interface IRepository {
    suspend fun getAllPayments() : List<Payments>
    suspend fun insertPayment(payments: Payments)
}