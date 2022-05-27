package com.romainbechard.findmearecipe.data.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class IngredientDTO(
    @JsonProperty("aisle") val aisle: String?,
    @JsonProperty("amount") val amount: Int?,
    @JsonProperty("id") val id: Int?,
    @JsonProperty("imageUrl") val imageUrl: String?,
    @JsonProperty("meta") val meta: List<Any?>?,
    @JsonProperty("name") val name: String?,
    @JsonProperty("orginalName") val originalName: String?,
    @JsonProperty("unit") val unit: String?,
    @JsonProperty("unitLong") val unitLong: String?,
    @JsonProperty("unitShort") val unitShort: String?,
)
