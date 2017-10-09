package com.example.ary.mimobakingapp.Widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by ary on 9/19/17.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.ary.mimobakingapp.Adapter.RecipeMainAdapter;
import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
public class MyWidgetRemoteViewsService extends RemoteViewsService {




    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        WidgetDataProvider data = new WidgetDataProvider(this, intent);
        return data;
    }
}
