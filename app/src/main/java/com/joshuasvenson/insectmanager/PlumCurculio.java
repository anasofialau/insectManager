package com.joshuasvenson.insectmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by anaso_000 on 10/9/2016.
 */

public class PlumCurculio extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plum_curculio);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Apples attacked by plum curculio frequently suffer surface scarring and distortion" +
                "from feeding and egg laying. \nThe most important injury results from the crescent-shaped " +
                "cuts made in apples by females during egg laying. \n\nInfested immature apples often fall " +
                "prematurely, or if they stay on the tree they may be hard, knotty, and misshapen.");

    }
}
