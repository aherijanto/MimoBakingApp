package com.example.ary.mimobakingapp.Widget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.R;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.example.ary.mimobakingapp.R.id.ingredients;

/**
 * Created by ary on 10/9/17.
 */

public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {

    public static final String SELECTED_RECIPE = "com.example.ary.mimobakingapp.SELECTED_RECIPE";

    private Context context;
    private Intent intent;
    private List<Ingredients> ingredientList = new ArrayList<>();

    public WidgetDataProvider(Context context, Intent intent){
        this.context = context;
        this.intent = intent;
    }

    void initData(){
        String sRecipe = intent.getStringExtra(SELECTED_RECIPE);
        Recipe recipe = new GsonBuilder().create().fromJson(sRecipe, Recipe.class);
        ingredientList.addAll(recipe.getIngredients());
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public int getCount() {
        return ingredientList.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        Ingredients ingredient = ingredientList.get(position);
        RemoteViews views = new RemoteViews(context.getPackageName(), android.R.layout.simple_list_item_1);
       // views.setTextViewText(android.R.id.text1, String.format(context.getString(R.string.ingredients_detail)
           //    , ingredient.getQuantity(),ingredient.getMeasure(), ingredient.getIngredient()));
        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
