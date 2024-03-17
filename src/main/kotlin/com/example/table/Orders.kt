package com.example.table

import org.jetbrains.exposed.sql.javatime.timestamp
import org.jetbrains.exposed.sql.Table

object Orders: Table() {
    val id = integer("id").autoIncrement()
    val userId = integer("userId").references(Users.id)
    val foodId = integer("foodId").references(Foods.id)
    val quantity = integer("quantity")
    val orderTime = timestamp("orderTime")

    override val primaryKey = PrimaryKey(id)
}
