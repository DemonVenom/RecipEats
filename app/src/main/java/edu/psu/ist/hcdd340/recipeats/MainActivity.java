package edu.psu.ist.hcdd340.recipeats;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.psu.ist.hcdd340.recipeats.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;




final class RecipeProfile {


    private final String profileName;
    private final String profileID;
    private final String location;
    private final int profileImageID;

    RecipeProfile(String profileName, String profileID, String location, int profileImageID) {
        this.profileName = profileName;
        this.profileID = profileID;
        this.location = location;
        this.profileImageID = profileImageID;
    }


    public int getProfileImageID() {
        return profileImageID;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfileID() {
        return profileID;
    }

    public String getLocation() {
        return location;
    }


}







public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private static final String TAG = "RECIPEATS_ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }



    private static final RecipeProfile[] RECIPE_PROFILES = {
            new RecipeProfile("Hosler Oak", "7863", "Arboretum", R.drawable.hosler_tree),
            new RecipeProfile("Banana", "7864", "Esplanade in Arboretum", R.drawable.banana_tree),
            new RecipeProfile("Hemlock", "7865", "Entry Walk in Arboretum", R.drawable.hemlock_tree),

            /*new RecipeProfile("Santa Cruz lily", "7866", "Oasis Garden & Lotus Pool", R.drawable.santa_cruiz_tree),
            new RecipeProfile("Flapjack", "7867", "Arboretum", R.drawable.flapjack_tree),
            new RecipeProfile("Japanese Peony", "7868", "Rose & Fragrance Garden", R.drawable.japanese_peony_tree),
            new RecipeProfile("Crab Apple", "7869", "Strolling Garden", R.drawable.crabapple_tree),
            new RecipeProfile("Black Pine", "7870", "Strolling Garden", R.drawable.blackpine_tree),
            new RecipeProfile("Hellebore", "7871", "Strolling Garden", R.drawable.hellebore_tree),
            new RecipeProfile("False Spirea", "7872", "Strolling Garden", R.drawable.spirea_tree),

             */
    };
























}