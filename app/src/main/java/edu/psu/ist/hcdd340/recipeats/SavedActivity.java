package edu.psu.ist.hcdd340.recipeats;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SavedActivity extends AppCompatActivity implements View.OnClickListener {



    private static final String TAG = "ACTIVITY_SAVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);




        Log.d(TAG, "On Create");

    }


    @Override
    public void onClick(View view) {



    }

}