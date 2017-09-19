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
        return new MyWidgetRemoteViewsFactory(this.getApplicationContext());
    }

    class MyWidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

        private Context context;
        private ArrayList<Ingredients> myIngredients;

        public MyWidgetRemoteViewsFactory(Context context) {
            this.context = context;

        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
           String json = preferences.getString(RecipeMainAdapter.SHARED_PREFS_KEY, "");
            if (!json.equals("")) {
                Gson gson = new Gson();
               myIngredients = gson.fromJson(json, new TypeToken<ArrayList<Ingredients>>() {
               }.getType());
            }
        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            if (myIngredients != null) {
                return myIngredients.size();
            } else return 0;
        }

        @Override
        public RemoteViews getViewAt(int position) {
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_item);
            rv.setTextViewText(R.id.widget_text_view, myIngredients.get(position).getIngredient());
            return rv;
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
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }
    }
}
