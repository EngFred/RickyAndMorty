package com.engineerfred.kotlin.core.network

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val info: Info,
    val results: List<CharacterDTO>
) {
    @Serializable
    data class Info(
        val count: Long,
        val pages: Long,
        val next: String?,
        val prev: String?
    )
}
