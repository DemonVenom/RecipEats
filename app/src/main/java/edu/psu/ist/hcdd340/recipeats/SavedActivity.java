package edu.psu.ist.hcdd340.recipeats;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SavedActivity extends AppCompatActivity {



    private static final String TAG = "ACTIVITY_SAVED";

    Button addview;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        // initialising layout
        addview = findViewById(R.id.addiview);
        layout = findViewById(R.id.layout);


        // we will click on the add view button
        addview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initialising new layout
                ImageView imageView = new ImageView(SavedActivity.this);

                // setting the image in the layout
                imageView.setImageResource(R.mipmap.ic_launcher);

                // calling addview with width and height
                addvieW(imageView, 200, 200);

                // adding the background color
                colorrandom(imageView);
            }
        });

    }


    public void colorrandom(ImageView imageView) {

        // Initialising the Random();
        Random random = new Random();

        // adding the random background color
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

        // setting the background color
        imageView.setBackgroundColor(color);
    }

    private void addvieW(ImageView imageView, int width, int height) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        params.setMargins(0, 10, 0, 10);
        imageView.setLayoutParams(params);

        // adding the image in layout
        layout.addView(imageView);
    }

}