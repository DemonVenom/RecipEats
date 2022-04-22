package edu.psu.ist.hcdd340.recipeats;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SavedActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        // initialising layout
        layout = findViewById(R.id.layout);

        addView();
    }


    private void addView() {

        for (int i = 0; i < MainActivity.RECIPE_PROFILES.length; i++) {

            if (MainActivity.RECIPE_PROFILES[i].getProfileLikeStatus() == true) {

                // initialising new layout
                ImageView imageView = new ImageView(SavedActivity.this);

                // setting the image in the layout
                imageView.setImageResource(MainActivity.RECIPE_PROFILES[i].getProfileImageID());


                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(500, 500);

                // setting the margin in linearlayout
                params.setMargins(0, 10, 0, 10);
                imageView.setLayoutParams(params);


                // adding the image in layout
                layout.addView(imageView);


            }

        }
    }
}