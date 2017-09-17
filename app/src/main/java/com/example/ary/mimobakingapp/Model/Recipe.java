package com.example.ary.mimobakingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ary on 9/15/17.
 */



public class Recipe implements Parcelable {
    private ArrayList<Ingredients> ingredients;

    private String id;

    private String servings;

    private String name;

    private String image;

    private ArrayList<Steps> steps;


    public Recipe(){


    }


    public Recipe(ArrayList<Ingredients> rIngredients,String recipeId, String rServings, String rName, String rImage, ArrayList<Steps> rSteps){

        this.ingredients=rIngredients;
        this.id=recipeId;
        this.servings=rServings;
        this.name=rName;
        this.image=rImage;
        this.steps=rSteps;

    }

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
    public String toString() {
        return "ClassPojo [ingredients = " + ingredients + ", id = " + id + ", servings = " + servings + ", name = " + name + ", image = " + image + ", steps = " + steps + "]";
    }

    protected Recipe(Parcel in) {
        if (in.readByte() == 0x01) {
            ingredients = new ArrayList<Ingredients>();
            in.readList(ingredients, Ingredients.class.getClassLoader());
        } else {
            ingredients = null;
        }
        id = in.readString();
        servings = in.readString();
        name = in.readString();
        image = in.readString();
        if (in.readByte() == 0x01) {
            steps = new ArrayList<Steps>();
            in.readList(steps, Steps.class.getClassLoader());
        } else {
            steps = null;
        }
    }

        @Override
        public int describeContents() {
        return 0;
    }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        if (ingredients == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(ingredients);
        }
        dest.writeString(id);
        dest.writeString(servings);
        dest.writeString(name);
        dest.writeString(image);
        if (steps == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(steps);
        }
    }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
            @Override
            public Recipe createFromParcel(Parcel in) {
                return new Recipe(in);
            }

            @Override
            public Recipe[] newArray(int size) {
                return new Recipe[size];
            }
        };
    }

