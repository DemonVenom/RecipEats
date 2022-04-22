package edu.psu.ist.hcdd340.recipeats;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static RecipeProfile[] RECIPE_PROFILES = {
            new RecipeProfile("Banana", "7864", false, R.drawable.banana_tree),
            new RecipeProfile("Hemlock", "7865", false, R.drawable.hemlock_tree),
            new RecipeProfile("Hosler Oak", "7863", false, R.drawable.hosler_tree),

            /*new RecipeProfile("Santa Cruz lily", "7866", "Oasis Garden & Lotus Pool", R.drawable.santa_cruiz_tree),
            new RecipeProfile("Flapjack", "7867", "Arboretum", R.drawable.flapjack_tree),
            new RecipeProfile("Japanese Peony", "7868", "Rose & Fragrance Garden", R.drawable.japanese_peony_tree),
            new RecipeProfile("Crab Apple", "7869", "Strolling Garden", R.drawable.crabapple_tree),
            new RecipeProfile("Black Pine", "7870", "Strolling Garden", R.drawable.blackpine_tree),
            new RecipeProfile("Hellebore", "7871", "Strolling Garden", R.drawable.hellebore_tree),
            new RecipeProfile("False Spirea", "7872", "Strolling Garden", R.drawable.spirea_tree),

             */
    };

    private static final String TAG = "RECIPEATS_ACTIVITY";


    public static final String EXTRA_RECIPE_PIC = "PROFILE_PIC";


    private static int imageID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ShapeableImageView button = findViewById(R.id.imageLike);
        button.setOnClickListener(this);

        button = findViewById(R.id.imageSearch);
        button.setOnClickListener(this);

        button = findViewById(R.id.imageSettings);
        button.setOnClickListener(this);



        button = findViewById(R.id.tree_image);
        button.setOnClickListener(this);


        button = findViewById(R.id.hopler_tree);
        button.setOnClickListener(this);



        button = findViewById(R.id.imageLike2);
        button.setOnClickListener(this);

        button = findViewById(R.id.imageLike3);
        button.setOnClickListener(this);






    }



    @Override
    public void onClick(View view) {
        /*
        Handle onClick events
         */



        switch (view.getId()) {
            case R.id.imageLike:

                handleLike();
                break;

            case R.id.imageSearch:

            case R.id.imageSettings:
                handleSettings();
                break;

            case R.id.tree_image:
                setCurrentProfile(0);
                handleRecipe();
                break;

            case R.id.hopler_tree:
                setCurrentProfile(1);
                handleRecipe();
                break;

            case R.id.imageLike2:
                markIconAsSelected(R.id.imageLike2, 0);
                break;

            case R.id.imageLike3:
                markIconAsSelected(R.id.imageLike3, 1);
                break;


        }
    }


    private void handleLike() {

        // Create new intent on SettingsActivity class
        Intent intent = new Intent(this, SavedActivity.class);


        startActivity(intent);

        // Commit intent
        // mGetStatus.launch(intent);
    }


    private void handleSettings() {

        // Create new intent on SettingsActivity class
        Intent intent = new Intent(this, SettingsActivity.class);


        startActivity(intent);

        // Commit intent
        // mGetStatus.launch(intent);
    }

    private void handleRecipe() {

        // Create new intent on SettingsActivity class
        Intent intent = new Intent(this, RecipeActivity.class);


        intent.putExtra(EXTRA_RECIPE_PIC, getCurrentProfile());


        startActivity(intent);

        // Commit intent
        // mGetStatus.launch(intent);
    }


    ActivityResultLauncher<Intent> mGetStatus = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    // Get child activity on whether "ok" or "cancel" was selected
                    int resultCode = result.getResultCode();

                    // On the condition that the ok button was pressed on settings child activity...
                    if (resultCode == RESULT_OK) {



                        // On the condition that the cancel button was pressed on settings child activity...
                    } else if (resultCode == RESULT_CANCELED) {

                        // Do nothing, report back doing nothing
                        Log.d(TAG, "Canceled from ShowProfileDetailsActivity");
                    } else {
                        Log.d(TAG, String.format("Unknown return code from ShowProfileDetailsActivity: %s", resultCode));
                    }
                }
            }
    );







    private int setCurrentProfile(int viewID) {

        imageID = viewID;

        return imageID;
    }


    private int getCurrentProfile() {

        return imageID;
    }


    private void markIconAsSelected(int iconId, int index) {

        // now update the background
        ShapeableImageView iconView = findViewById(iconId);


        boolean likeStatus = RECIPE_PROFILES[index].getProfileLikeStatus();



        if (likeStatus == false) {

            iconView.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_gray));

        }
        else {

            iconView.setBackgroundColor(ContextCompat.getColor(this, R.color.light_gray));

        }


        RECIPE_PROFILES[index].setProfileLikeStatus( !likeStatus );


    }




}