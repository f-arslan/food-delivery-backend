package com.example.table

import com.example.dto.FoodCategory
import org.jetbrains.exposed.sql.Table

object Foods : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val description = varchar("description", 256)
    val price = decimal("price", 10, 2)
    val rating = double("rating")
    val orderCount = integer("orderCount")
    val category = enumerationByName("category", 20, FoodCategory::class)
    val imageUrl = varchar("imageUrl", 256)

    override val primaryKey = PrimaryKey(id)
}
