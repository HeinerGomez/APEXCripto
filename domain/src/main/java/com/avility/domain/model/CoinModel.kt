package com.avility.domain.model

data class CoinModel(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean,
    val type: String,
    val logo: String?,
    val description: String?,
    val isOpenSource: Boolean?,
    val orgStructure: String?,
)
