package com.philipcutting.todo.networking

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ToDoApi {
    @GET("/")
    fun getToDoItems(): Call<Items>

    @POST("/add")
    fun addToDoItem(@Body item: Item): Call<Items>
}