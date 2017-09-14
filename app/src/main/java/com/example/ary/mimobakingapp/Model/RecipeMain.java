package com.example.ary.mimobakingapp.Model;

/**
 * Created by ary on 9/14/17.
 */

public class RecipeMain {

    private Integer recipeId;
    private String recipeName;
    private Integer recipeServing;

    public RecipeMain(){

    }

    public RecipeMain(Integer recipeId, String recipeName, Integer recipeServing)
    {
        this.recipeId=recipeId;
        this.recipeName=recipeName;
    }


    public Integer getRecipeId(){
        return  recipeId;
    }

    public String getRecipeName(){
        return recipeName;
    }

    public Integer getRecipeServing() {
        return recipeServing;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRecipeServing(Integer recipeServing) {
        this.recipeServing = recipeServing;
    }
}

