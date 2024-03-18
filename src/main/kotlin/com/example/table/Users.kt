package com.example.table

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement()
    val userId = uuid("userId").uniqueIndex().autoGenerate()
    val fullName = varchar("fullName", 128)
    val email = varchar("email", 128)
    val password = varchar("password", 128)
    val phoneNumber = varchar("phoneNumber", 128).nullable()
    val occupation = varchar("occupation", 128).nullable()
    val employer = varchar("employer", 128).nullable()
    val country = varchar("country", 128).nullable()
    val latitude = double("latitude").nullable()
    val longitude = double("longitude").nullable()

    override val primaryKey = PrimaryKey(id)
}
