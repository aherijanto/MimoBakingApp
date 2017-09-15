package com.example.ary.mimobakingapp.Utilities;

import android.content.Context;

import com.example.ary.mimobakingapp.Model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ary on 9/14/17.
 */

public class RecipeOnJSON {

    public static ArrayList<Recipe> getRecipeName(Context context, String recipeListJSON)
            throws JSONException{

        final String recipeList="rcplist";
        final String recipeNameField="name";
        final String recipeIDField="id";
        final String recipeIngField="ingredient";
        final String recipeServing="servings";



        JSONArray recipeJSONArray = new JSONArray(recipeListJSON);
        JSONObject myJSONObject;



        ArrayList<Recipe> dataRecipe=new ArrayList();

        for (int i = 0; i < recipeJSONArray.length(); i++){
            Integer recipeID;
            String recipeName;

            Recipe mdataRecipe=new Recipe();

            myJSONObject = recipeJSONArray.getJSONObject(i);

            mdataRecipe.setId(myJSONObject.getString(recipeIDField));
            mdataRecipe.setName( myJSONObject.getString(recipeNameField));
            mdataRecipe.setServings(myJSONObject.getString(recipeServing));

            dataRecipe.add(mdataRecipe);


        }


        return dataRecipe;

    }
}
