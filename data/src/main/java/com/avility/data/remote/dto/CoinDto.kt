package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class CoinDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    @field:Json(name = "is_new")
    val isNew: Boolean,
    @field:Json(name = "is_active")
    val isActive: Boolean,
    val type: String,
    val logo: String?,
    val description: String?,
    @field:Json(name = "open_source")
    val isOpenSource: Boolean?,
    @field:Json(name = "org_structure")
    val orgStructure: String?,
)