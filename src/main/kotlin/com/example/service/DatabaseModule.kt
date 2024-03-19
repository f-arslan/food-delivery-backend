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
import java.net.URI


object DatabaseModule {
    fun init() {
        val databaseUrl = System.getenv("DATABASE_URL") ?: "DEFAULT_DATABASE_URL"
        val dbUri = URI(databaseUrl)

        val username = dbUri.userInfo.split(":")[0]
        val password = dbUri.userInfo.split(":")[1]
        val dbUrl = "jdbc:postgresql://" + dbUri.host + ':' + dbUri.port + dbUri.path + "?sslmode=require"

        val database = Database.connect(dbUrl, driver = "org.postgresql.Driver", user = username, password = password)
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
