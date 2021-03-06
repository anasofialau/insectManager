package com.joshuasvenson.insectmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by anaso_000 on 10/9/2016.
 */

/*
Name: Diseases
Description: This class provides the code for the Insects screen and activity of the app and
manages the button clicks and info to be displayehd in the textviews.
Layout File: activity_diseases.xml
 */
public class Diseases extends AppCompatActivity {
    //Initializes listview in the screen
    ListView listView;

    String diseases[];

    /*
    Name: onCreate
    Description: Creates activity
    Parameters: Bundle savedInstanceState
    Returns: void
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        //Set listview to its reference in the corresponding xml file (activity_diseases.xml)
        listView = (ListView)findViewById(R.id.listView);

        // Initializes the array of strings of the diseases that will be inserted into the listview
        String[] diseases = {"Apple Scab", "Powdery Mildew", "Black Rot", "Collar Rot", "Fire Blight"};

        //Initializes the array of the images
        Integer diseaseImages[] = {R.drawable.apple_scab_list_view,
                R.drawable.powdery_mildew_list_view,
                R.drawable.black_rot_list_view,
                R.drawable.collar_rot_list_view,
                R.drawable.fire_blight_list_view};

        ListAdapter adapter = new ListAdapter(this, diseases, diseaseImages);

        listView.setAdapter(adapter);

        //Set Click listener for the listview in the screen, and create an intent for each different position
        //clicked by the user.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                if(position==0){
                    Intent one = new Intent(Diseases.this, AppleScab.class);
                    startActivity(one);
                }
                if(position==1){
                    Intent two = new Intent(Diseases.this, PowderyMildew.class);
                    startActivity(two);
                }
                if(position == 2){
                    Intent three = new Intent(Diseases.this, BlackRot.class);
                    startActivity(three);
                }
                if (position == 3){
                    Intent four = new Intent(Diseases.this, CollarRot.class);
                    startActivity(four);
                }
                if (position == 4){
                    Intent five = new Intent(Diseases.this, FireBlight.class);
                    startActivity(five);
                }
            }
        });
    }



    /*
    Name: onCreateOptionsMenu
    Description: Initialize the contents of the Activity's standard options menu.
    Parameters: Menu menu - The options menu in which you place your items.
    Returns: boolean - You must return true for the menu to be displayed; if you return false it will not be shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu. This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true to display menu
        return true;
    }

    /*
    Name: onOptionsItemSelected
    Description: This hook is called whenever an item in your options menu is selected. The default implementation
                simply returns false to have the normal processing happen (calling the item's Runnable or sending
                a message to its Handler as appropriate). You can use this method for any items for which you would
                like to do processing without those other facilities.
    Parameters: MenuItem item - The menu item that was selected.
    Returns: boolean - Return false to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final Context context = this;

        //noinspection SimplifiableIfStatement
        if (id == R.id.Home_bar) {
            Intent intent = new Intent(context, Home.class);
            startActivity(intent);
            return true;
        }
        else if(id ==R.id.Insects_bar) {
            Intent intent = new Intent(context, Insects.class);
            startActivity(intent);
            return true;
        }
        else if(id ==R.id.Diseases_bar) {
            Intent intent = new Intent(context, Diseases.class);
            startActivity(intent);
            return true;
        }
        else if(id ==R.id.LocalWeather_bar) {
            Intent intent = new Intent(context, Weather1.class);
            startActivity(intent);
            return true;
        }
        else if(id ==R.id.Settings_bar) {
            Intent intent = new Intent(context, SettingsToolbar.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
