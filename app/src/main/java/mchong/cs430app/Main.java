package mchong.cs430app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        })*/;
    }

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

    // strike zone practice algorithm

    // assign user input for successes in each zone to ints for use in algorithm
    int z1field = input1;
    int z2field = input2;
    int z3field = input3;
    int z4field = input4;
    int z5field = input5;
    int z6field = input6;
    int z7field = input7;
    int z8field = input8;
    int z9field = input9;

    // int array to store the current amount of reps for each zone
    int[] reps = new int[9];

    reps[0] = z1reps;
    reps[1] = z2reps;
    reps[2] = z3reps;
    reps[3] = z4reps;
    reps[4] = z5reps;
    reps[5] = z6reps;
    reps[6] = z7reps;
    reps[7] = z8reps;
    reps[8] = z9reps;

    // int array to store zone efficiency information
    int[] zoneEff = new int[9];

    // success rates for each zone set using user input and known rep totals
    zoneEff[0] = z1field / z1reps;
    zoneEff[1] = z2field / z2reps;
    zoneEff[2] = z3field / z3reps;
    zoneEff[3] = z4field / z4reps;
    zoneEff[4] = z5field / z5reps;
    zoneEff[5] = z6field / z6reps;
    zoneEff[6] = z7field / z7reps;
    zoneEff[7] = z8field / z8reps;
    zoneEff[8] = z9field / z9reps;

    // int array to store the adjusted amount of reps for each zone
    int[] adjReps = new int[9];

    // the user’s goal for efficiency in each zone (50% to start with)
    double goal = 0.5;

    // check the efficiencies for each zone and adjust them accordingly
    for(int i = 0; i < 9; i++)
    {
        // if current zone efficiency is below target effiency
        if(zoneEff[i] < goal)
        {
            // increase reps for that zone by the same % goal efficiency
            adjReps[i] = reps[i] + (reps[i] * goal);
            // decrease reps for other zones by 10% if they're already hitting the target efficiency
            for(int j = 0; j < 9; j++)
            {
                if(j != i)
                {
                    if(zoneEff[j] >= goal)
                    {
                        adjReps[j] = reps[j] - (reps[j] * 0.1);
                    }
                }
            }
        }
    }

    // edit text fields to display the adjusted reps for each zone

}
