package com.example.table

import org.jetbrains.exposed.sql.Table

object Foods : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val description = varchar("description", 256)
    val price = double("price")
    val rating = double("rating")
    val orderCount = integer("orderCount")
    val type = varchar("type", 128)
    val imageUrl = varchar("imageUrl", 256)

    override val primaryKey = PrimaryKey(id)
}
