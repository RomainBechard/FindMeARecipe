package com.romainbechard.findmearecipe.data.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class RecipeDTO(
    @JsonProperty("id") val id: Int,
    @JsonProperty("image") val imageUrl: String?,
    @JsonProperty("imageType") val imageType: String?,
    @JsonProperty("likes") val likesCount: Int?,
    @JsonProperty("missedIngredientCount") val missedIngredientCount: Int?,
    @JsonProperty("missedIngredients") val missedIngredientsList: List<IngredientDTO?>?,

)
