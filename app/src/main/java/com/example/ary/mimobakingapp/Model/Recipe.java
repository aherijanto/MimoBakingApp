package com.example.ary.mimobakingapp.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ary on 9/15/17.
 */

public class Recipe
{
    private ArrayList<Ingredients> ingredients;

    private String id;

    private String servings;

    private String name;

    private String image;

    private ArrayList<Steps> steps;

    public ArrayList<Ingredients> getIngredients ()
    {
        return ingredients;
    }

    public void setIngredients (ArrayList<Ingredients> ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getServings ()
    {
        return servings;
    }

    public void setServings (String servings)
    {
        this.servings = servings;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public ArrayList<Steps> getSteps ()
    {
        return steps;
    }

    public void setSteps (ArrayList<Steps> steps)
    {
        this.steps = steps;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ingredients = "+ingredients+", id = "+id+", servings = "+servings+", name = "+name+", image = "+image+", steps = "+steps+"]";
    }
}
