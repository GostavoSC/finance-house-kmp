package repository

import entity.Payments

interface ICacheData {
    suspend fun getAllPayments(): List<Payments>
    suspend fun insertPayment(payments: Payments)
}