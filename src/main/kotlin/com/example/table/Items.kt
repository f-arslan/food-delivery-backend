package com.example.table

import org.jetbrains.exposed.sql.Table

object Items : Table() {
    val id = integer("id").autoIncrement()
    val orderId = integer("orderId").references(Orders.id)
    val foodId = integer("foodId").references(Foods.id)
    val quantity = integer("quantity")
    val price = decimal("price", 10, 2)
}
