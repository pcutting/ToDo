package com.philipcutting.todo.networking


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Items (
    @Json(name = "items" ) val items: List<Item>
)

@JsonClass(generateAdapter = true)
data class Item (
    @Json(name = "item") val item: String,
    @Json(name = "priority") val priority: Int
)