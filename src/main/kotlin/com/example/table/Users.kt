package com.example.table

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement()
    val fullName = varchar("fullName", 128)
    val email = varchar("email", 128)
    val password = varchar("password", 128)
    val phoneNumber = varchar("phoneNumber", 128)
    val occupation = varchar("occupation", 128)
    val employer = varchar("employer", 128)
    val country = varchar("country", 128)

    override val primaryKey = PrimaryKey(id)
}
