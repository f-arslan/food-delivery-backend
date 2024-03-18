package com.example.table

import com.example.dto.OrderStatus
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.javatime.timestamp
import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

object Orders : Table() {
    val id = integer("id").autoIncrement()
    val userId = uuid("userId").references(Users.userId)
    val orderTime = timestamp("orderTime").clientDefault { Clock.System.now().toJavaInstant() }
    val orderStatus = enumerationByName("orderStatus", 15, OrderStatus::class).clientDefault { OrderStatus.Pending }
    val totalPrice = decimal("totalPrice", 10, 2).clientDefault { BigDecimal.ZERO }
    val paymentDetails = varchar("paymentDetails", 255).nullable()
    override val primaryKey = PrimaryKey(id)
}
