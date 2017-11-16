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

                    //int  z1CurrReps = Integer.parseInt(z1reps.getText().toString());

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
                    double[] zoneEff = new double[] {
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

                    // marks whether or not it is the first time passing through the inner loop (j)
                    boolean initialLoop = true;

                    // check the efficiencies for each zone and adjust them accordingly
                    for(int i = 0; i < 9; i++)
                    {
                        // if current zone efficiency is below target (goal) efficiency
                        if(zoneEff[i] < goal)
                        {
                            // increase reps for that zone by the same % goal efficiency
                            adjReps[i] = (int) (reps[i] + (reps[i] * goal));
                            // decrease reps for other zones by 1 if they're already hitting the target efficiency
                            // otherwise keep them the same until their reps are increased or if their reps already have been increased
                            for(int j = 0; j < 9; j++)
                            {
                                // if the current zone being viewed is not the same as the one that was already changed
                                if(j != i)
                                {
                                    // if this is the first time going through the loop use previous values
                                    // else, use the adjusted rep values to calculate the newest ones
                                    if(initialLoop = true)
                                    {
                                        // if the efficiency of the zone is greater than or equal to the goal efficiency
                                        if (zoneEff[j] >= goal) {
                                            // decrease the amount of reps for that zone by one
                                            adjReps[j] = reps[j] - 2;
                                        }
                                        else
                                        {
                                            adjReps[j] = adjReps[j] - 2;
                                        }
                                    }
                                }
                            }
                            // the initial loop through the reps is finished
                            initialLoop = false;
                        }
                    }

                    // edit text fields to display the adjusted reps for each zone
                    // rep counts should be no higher than 20 and no lower than 5
                    String[] newText = new String[9];

                    for(int h = 0; h < 9; h++)
                    {
                        if (adjReps[h] <= 20 && adjReps[h] >= 5)
                        {
                            newText[h] = Integer.toString(adjReps[h]);
                        }
                        else if(adjReps[h] > 20)
                        {
                            newText[h] = "20";
                        }
                        else if(adjReps[h] < 5)
                        {
                            newText[h] = "5";
                        }
                    }

                    z1reps.setText(newText[0]);
                    z2reps.setText(newText[1]);
                    z3reps.setText(newText[2]);
                    z4reps.setText(newText[3]);
                    z5reps.setText(newText[4]);
                    z6reps.setText(newText[5]);
                    z7reps.setText(newText[6]);
                    z8reps.setText(newText[7]);
                    z9reps.setText(newText[8]);

                    /*String z1text = Integer.toString(adjReps[0]);
                    String z2text = Integer.toString(adjReps[1]);
                    String z3text = Integer.toString(adjReps[2]);
                    String z4text = Integer.toString(adjReps[3]);
                    String z5text = Integer.toString(adjReps[4]);
                    String z6text = Integer.toString(adjReps[5]);
                    String z7text = Integer.toString(adjReps[6]);
                    String z8text = Integer.toString(adjReps[7]);
                    String z9text = Integer.toString(adjReps[8]);*/
                    /*z1reps.setText(Integer.toString(adjReps[0]));
                    z2reps.setText(Integer.toString(adjReps[1]));
                    z3reps.setText(Integer.toString(adjReps[2]));
                    z4reps.setText(Integer.toString(adjReps[3]));
                    z5reps.setText(Integer.toString(adjReps[4]));
                    z6reps.setText(Integer.toString(adjReps[5]));
                    z7reps.setText(Integer.toString(adjReps[6]));
                    z8reps.setText(Integer.toString(adjReps[7]));
                    z9reps.setText(Integer.toString(adjReps[8]));*/

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
