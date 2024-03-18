package com.example.table

import kotlinx.datetime.Clock
import kotlinx.datetime.toJavaInstant
import org.jetbrains.exposed.sql.javatime.timestamp
import org.jetbrains.exposed.sql.Table

object Orders: Table() {
    val id = integer("id").autoIncrement()
    val userId = uuid("userId").references(Users.userId)
    val foodId = integer("foodId").references(Foods.id)
    val quantity = integer("quantity")
    val orderTime = timestamp("orderTime").clientDefault { Clock.System.now().toJavaInstant() }

    override val primaryKey = PrimaryKey(id)
}
