package com.example.ary.mimobakingapp.Utilities;

import android.content.Context;

import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;

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

        final String ingredientQty="quantity";
        final String ingredienMeasure="measure";
        final String ingredientIng="ingredient";

        final String stepsId="id";
        final String stepsShortDesc="shortDescription";
        final String stepsDesc="description";
        final String stepsVideo="videoURL";
        final String stepsThumb="thunbnailURL";




        JSONArray recipeJSONArray = new JSONArray(recipeListJSON);
        JSONObject myJSONObject;



        ArrayList<Recipe> dataRecipe=new ArrayList();
        ArrayList<Ingredients> dataIngredient= new ArrayList<>();
        ArrayList<Steps> dataSteps=new ArrayList<>();

        for (int i = 0; i < recipeJSONArray.length(); i++){
            Integer recipeID;
            String recipeName;

            Recipe mdataRecipe=new Recipe();

            myJSONObject = recipeJSONArray.getJSONObject(i);

            mdataRecipe.setId(myJSONObject.getString(recipeIDField));
            mdataRecipe.setName( myJSONObject.getString(recipeNameField));
            mdataRecipe.setServings(myJSONObject.getString(recipeServing));

            //parsing ingredient
            JSONArray ingredientJSONArray=myJSONObject.getJSONArray(recipeIngField);
            JSONObject ingredientJSONObject;

            for (int j = 0;j< ingredientJSONArray.length();j++){
                Ingredients mdataIngredient= new Ingredients();

                ingredientJSONObject=ingredientJSONArray.getJSONObject(i);

                mdataIngredient.setQuantity(ingredientJSONObject.getString(ingredientQty));
                mdataIngredient.setMeasure(ingredientJSONObject.getString(ingredienMeasure));
                mdataIngredient.setIngredient(ingredientJSONObject.getString(ingredientIng));
            }


                        //parsing steps
            JSONArray stepsJSONArray=myJSONObject.getJSONArray(recipeIngField);
            JSONObject stepsJSONObject;

            for (int k = 0;k< stepsJSONArray.length();k++){

                Steps mdataSteps= new Steps();

                stepsJSONObject=stepsJSONArray.getJSONObject(i);

                mdataSteps.setId(stepsJSONObject.getString(stepsId));
                mdataSteps.setShortDescription(stepsJSONObject.getString(stepsShortDesc));
                mdataSteps.setDescription(stepsJSONObject.getString(stepsDesc));
                mdataSteps.setThumbnailURL(stepsJSONObject.getString(stepsThumb));
                mdataSteps.setVideoURL(stepsJSONObject.getString(stepsVideo));
            }


            dataRecipe.add(mdataRecipe);


        }


        return dataRecipe;

    }
}
