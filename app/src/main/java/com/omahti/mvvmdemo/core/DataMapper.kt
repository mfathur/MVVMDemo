package com.omahti.mvvmdemo.core

import com.omahti.mvvmdemo.data.source.local.PostEntity
import com.omahti.mvvmdemo.data.source.network.response.PostResponse

object DataMapper {
    fun mapPostResponsesToEntities(responses: List<PostResponse>): List<PostEntity> {
        val list = ArrayList<PostEntity>()

        responses.map { postResponse ->
            val postEntity = PostEntity(
                id = postResponse.id ?: "asdasd",
                name = postResponse.name ?: "no name",
                username = postResponse.username ?: " no username",
                email = postResponse.email ?: "no email"
            )
            list.add(postEntity)
        }
        return list
    }
}