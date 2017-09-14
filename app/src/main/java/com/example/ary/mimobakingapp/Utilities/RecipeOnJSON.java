package com.example.ary.mimobakingapp.Utilities;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        JSONObject recipeObjectJSON = new JSONObject(recipeListJSON);
        JSONArray recipeListArray=recipeObjectJSON.getJSONArray(recipeList);

        parsedRecipe=new String[recipeListArray.length()];

        for (int i = 0; i < recipeListArray.length(); i++){
            String recipeName;

            JSONObject myList = recipeListArray.getJSONObject(i);
            JSONObject recipeObject = myList.getJSONArray(recipeIDField).getJSONObject(0);
            recipeName = recipeObject.getString(recipeNameField);

            parsedRecipe[i]=recipeName;

        }

        return parsedRecipe;


    }
}
