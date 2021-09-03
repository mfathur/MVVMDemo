package com.omahti.mvvmdemo.data.source.network.response

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("username")
    val username: String?,

    @SerializedName("email")
    val email: String?
)