package com.example.ary.mimobakingapp.API;

import com.example.ary.mimobakingapp.Model.RecipeJSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ary on 9/14/17.
 */

public interface RecipeInterface
{
    @GET("59121517_baking/baking.json")
    Call<RecipeJSONResponse> getJSON();
}
