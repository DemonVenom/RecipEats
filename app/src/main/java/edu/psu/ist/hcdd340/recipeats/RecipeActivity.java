package edu.psu.ist.hcdd340.recipeats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class RecipeActivity extends AppCompatActivity implements View.OnClickListener {



    private static final String TAG = "ACTIVITY_RECIPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        int image = intent.getIntExtra(MainActivity.EXTRA_RECIPE_PIC, 0);


        Log.d(TAG, "" + image);


        ShapeableImageView view;
        view = findViewById(R.id.tree_image);



        view.setImageResource(MainActivity.RECIPE_PROFILES[image].getProfileImageID());






        Log.d(TAG, "On Create");

    }


    @Override
    public void onClick(View view) {



    }










}