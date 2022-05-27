package com.romainbechard.findmearecipe.data.source

import com.romainbechard.findmearecipe.data.model.dto.GetRecipeByIngredientsResponse
import retrofit2.http.GET

interface SpoonApi {

    @GET("/resipes/complexSearch")
    suspend fun getComplexSearch()

    @GET("/recipes/findByIngredients")
    suspend fun getRecipeByIngredients(): GetRecipeByIngredientsResponse
}