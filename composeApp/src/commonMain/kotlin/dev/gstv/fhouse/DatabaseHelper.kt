package dev.gstv.fhouse


import com.squareup.sqldelight.db.SqlDriver
import dev.gstv.fhouse.cache.PaymentsDb
import entity.Payments
import kotlinx.coroutines.CoroutineDispatcher

class DatabaseHelper(
    sqlDriver: SqlDriver,
    private val backgroundDispatcher: CoroutineDispatcher
) {
    private val dbRef: PaymentsDb = PaymentsDb(sqlDriver)


    fun getAllTest(): List<Payments> {
        return dbRef.myDatabaseQueries.selectAllPayments().executeAsList()
            .map { Payments(it.id, it.name, it.description, it.date, it.value_) }
    }

    fun insertPayment(payments: Payments) {
        dbRef.myDatabaseQueries.insertPayment(
            id = null,
            name = payments.name,
            description = payments.description,
            date = payments.date,
            value_ = payments.value
        )
    }

//    fun selectAllItems(): Flow<List<Breed>> = dbRef.tableQueries
//        .selectAll()
//        .asFlow()
//        .mapToList(Dispatchers.Default)
//        .flowOn(backgroundDispatcher)
//
//    suspend fun insertBreeds(breeds: List<String>) {
//        log.d { "Inserting ${breeds.size} breeds into database" }
//        dbRef.transactionWithContext(backgroundDispatcher) {
//            breeds.forEach { breed ->
//                dbRef.tableQueries.insertBreed(breed)
//            }
//        }
//    }
//
//    fun selectById(id: Long): Flow<List<Breed>> = dbRef.tableQueries
//        .selectById(id)
//        .asFlow()
//        .mapToList(Dispatchers.Default)
//        .flowOn(backgroundDispatcher)
//
//    suspend fun deleteAll() {
//        log.i { "Database Cleared" }
//        dbRef.transactionWithContext(backgroundDispatcher) {
//            dbRef.tableQueries.deleteAll()
//        }
//    }
//
//    suspend fun updateFavorite(breedId: Long, favorite: Boolean) {
//        log.i { "Breed $breedId: Favorited $favorite" }
//        dbRef.transactionWithContext(backgroundDispatcher) {
//            dbRef.tableQueries.updateFavorite(favorite, breedId)
//        }
//    }
}
