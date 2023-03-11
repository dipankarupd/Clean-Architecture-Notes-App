package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

sealed class Order(val orderType: OrderType) {

    class Title(orderType: OrderType): Order(orderType)
    class Date(orderType: OrderType): Order(orderType)
    class Color(orderType: OrderType): Order(orderType)

}
