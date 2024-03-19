package com.example.service

import com.example.table.Foods
import com.example.table.Items
import com.example.table.Orders
import com.example.table.Users
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction


object DatabaseModule {
    fun init() {
        val driverClassName = "org.postgresql.Driver"
        val jdbcURL = System.getenv("JDBC_URL") ?: "DEFAULT_JDBC_URL"
        val database = Database.connect(jdbcURL, driverClassName)
        transaction(database) {
            SchemaUtils.create(Users)
            SchemaUtils.create(Foods)
            SchemaUtils.create(Orders)
            SchemaUtils.create(Items)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): Result<T> = runCatching {
        newSuspendedTransaction(Dispatchers.IO) { block() }
    }
}
