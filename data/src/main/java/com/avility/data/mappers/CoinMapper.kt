package com.avility.data.mappers

import com.avility.data.remote.dto.CoinDto
import com.avility.domain.model.CoinModel

fun CoinDto.toModel(): CoinModel = CoinModel(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    isNew = isNew,
    isActive = isActive,
    type = type,
    logo = logo,
    description = description,
    isOpenSource = isOpenSource,
    orgStructure = orgStructure
)