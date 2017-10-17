package mchong.cs430app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Button submit = (Button) findViewById(R.id.submitButton);
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

        if(submit != null)
        {
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // strike zone practice algorithm

                    EditText z1 = (EditText) findViewById(R.id.ZoneOneInput);
                    EditText z2 = (EditText) findViewById(R.id.ZoneTwoInput);
                    EditText z3 = (EditText) findViewById(R.id.ZoneThreeInput);
                    EditText z4 = (EditText) findViewById(R.id.ZoneFourInput);
                    EditText z5 = (EditText) findViewById(R.id.ZoneFiveInput);
                    EditText z6 = (EditText) findViewById(R.id.ZoneSixInput);
                    EditText z7 = (EditText) findViewById(R.id.ZoneSevenInput);
                    EditText z8 = (EditText) findViewById(R.id.ZoneEightInput);
                    EditText z9 = (EditText) findViewById(R.id.ZoneNineInput);

                    TextView z1reps = (TextView) findViewById(R.id.textView2);
                    TextView z2reps = (TextView) findViewById(R.id.textView3);
                    TextView z3reps = (TextView) findViewById(R.id.textView4);
                    TextView z4reps = (TextView) findViewById(R.id.textView5);
                    TextView z5reps = (TextView) findViewById(R.id.textView6);
                    TextView z6reps = (TextView) findViewById(R.id.textView7);
                    TextView z7reps = (TextView) findViewById(R.id.textView8);
                    TextView z8reps = (TextView) findViewById(R.id.textView9);
                    TextView z9reps = (TextView) findViewById(R.id.textView10);


                    // assign user input for successes in each zone to ints for use in algorithm
                    int z1field = Integer.parseInt(z1.getText().toString());
                    int z2field = Integer.parseInt(z2.getText().toString());
                    int z3field = Integer.parseInt(z3.getText().toString());
                    int z4field = Integer.parseInt(z4.getText().toString());
                    int z5field = Integer.parseInt(z5.getText().toString());
                    int z6field = Integer.parseInt(z6.getText().toString());
                    int z7field = Integer.parseInt(z7.getText().toString());
                    int z8field = Integer.parseInt(z8.getText().toString());
                    int z9field = Integer.parseInt(z9.getText().toString());

                    int  z1CurrReps = Integer.parseInt(z1reps.getText().toString());

                    // int array to store the current amount of reps for each zone
                    int[] reps = new int[] {
                            Integer.parseInt(z1reps.getText().toString()),
                            Integer.parseInt(z2reps.getText().toString()),
                            Integer.parseInt(z3reps.getText().toString()),
                            Integer.parseInt(z4reps.getText().toString()),
                            Integer.parseInt(z5reps.getText().toString()),
                            Integer.parseInt(z6reps.getText().toString()),
                            Integer.parseInt(z7reps.getText().toString()),
                            Integer.parseInt(z8reps.getText().toString()),
                            Integer.parseInt(z9reps.getText().toString())
                    };

                    // int array to store zone efficiency information
                    // success rates for each zone set using user input and known rep totals
                    int[] zoneEff = new int[] {
                            z1field / reps[0],
                            z2field / reps[1],
                            z3field / reps[2],
                            z4field / reps[3],
                            z5field / reps[4],
                            z6field / reps[5],
                            z7field / reps[6],
                            z8field / reps[7],
                            z9field / reps[8]
                    };

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
                            adjReps[i] = (int) (reps[i] + (reps[i] * goal));
                            // decrease reps for other zones by 10% if they're already hitting the target efficiency
                            for(int j = 0; j < 9; j++)
                            {
                                if(j != i)
                                {
                                    if(zoneEff[j] >= goal)
                                    {
                                        adjReps[j] = (int) (reps[j] - (reps[j] * 0.1));
                                    }
                                }
                            }
                        }
                    }

                    // edit text fields to display the adjusted reps for each zone

                } // end onClick
            }); // end setOnClickListener
        } // end if(submit != null)
    } // end onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    } // end onCreateOptionsMenu

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
    } // end onOptionsItemSelected
}
