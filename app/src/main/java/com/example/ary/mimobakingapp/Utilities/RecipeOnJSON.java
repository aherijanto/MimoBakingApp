package com.example.ary.mimobakingapp.Utilities;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ary on 9/14/17.
 */

public class RecipeOnJSON {

    public static String[] getRecipeName(Context context, String recipeListJSON)
            throws JSONException{

        final String recipeList="rcplist";
        final String recipeNameField="name";
        final String recipeIDField="id";

        String[] parsedRecipe;

        JSONArray recipeJSONArray = new JSONArray(recipeListJSON);
        JSONObject myJSONObject;

        parsedRecipe=new String[recipeJSONArray.length()];

        for (int i = 0; i < recipeJSONArray.length(); i++){
            String recipeName;

            myJSONObject = recipeJSONArray.getJSONObject(i);

            recipeName = myJSONObject.getString(recipeNameField);

            parsedRecipe[i]=recipeName;

        }


        return parsedRecipe;

    }
}
