package mchong.cs430app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
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
import android.widget.ImageButton;
import static java.lang.Double.compare;
import android.app.ActionBar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main extends AppCompatActivity {
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Button submit = (Button) findViewById(R.id.submitButton);
        ImageButton help = (ImageButton) findViewById(R.id.helpButton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        })*/;

        if(help != null) {
            help.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog helpAlert = new AlertDialog.Builder(Main.this).create();
                    helpAlert.setTitle("Help");
                    helpAlert.setMessage("How to use your routine:" + System.lineSeparator() + "1. Perform the amount of reps displayed for each sub-zone of the strike zone."
                            + System.lineSeparator() + "(You may do them in whatever order you choose and in a manner that makes the most sense to you)" + System.lineSeparator()
                            + "2. Input the amount of SUCCESSFUL reps performed for each sub-zone." + System.lineSeparator() + "(If none of the reps are successful, input a '0'"
                            + System.lineSeparator() + "3. Once all sub-zones have had their reps entered, press the 'Submit' button." + System.lineSeparator() + System.lineSeparator()
                            + "Every time you go through your routine, the rep count for each sub-zone will be adjusted to reflect your current skill level." + System.lineSeparator()
                            + System.lineSeparator() + "Reps added to a zone indicate that improvement is needed, and reps deducted from a zone indicate that you are already at or above" +
                            "your desired skill-level.");
                    helpAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    helpAlert.show();
                    Button errorOkButton = helpAlert.getButton(AlertDialog.BUTTON_NEUTRAL);
                    errorOkButton.setBackgroundColor(Color.rgb(214, 215, 215));
                    errorOkButton.setTextColor(Color.BLACK);
                }
            });
        }

        if(submit != null)
        {
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // strike zone practice algorithm

                    EditText z1 = (EditText) findViewById(R.id.ZoneOneInput);
                    if(isEmpty(z1)) {
                        z1.setText("0");
                    }
                    EditText z2 = (EditText) findViewById(R.id.ZoneTwoInput);
                    if(isEmpty(z2)) {
                        z2.setText("0");
                    }
                    EditText z3 = (EditText) findViewById(R.id.ZoneThreeInput);
                    if(isEmpty(z3)) {
                        z3.setText("0");
                    }
                    EditText z4 = (EditText) findViewById(R.id.ZoneFourInput);
                    if(isEmpty(z4)) {
                        z4.setText("0");
                    }
                    EditText z5 = (EditText) findViewById(R.id.ZoneFiveInput);
                    if(isEmpty(z5)) {
                        z5.setText("0");
                    }
                    EditText z6 = (EditText) findViewById(R.id.ZoneSixInput);
                    if(isEmpty(z6)) {
                        z6.setText("0");
                    }
                    EditText z7 = (EditText) findViewById(R.id.ZoneSevenInput);
                    if(isEmpty(z7)) {
                        z7.setText("0");
                    }
                    EditText z8 = (EditText) findViewById(R.id.ZoneEightInput);
                    if(isEmpty(z8)) {
                        z8.setText("0");
                    }
                    EditText z9 = (EditText) findViewById(R.id.ZoneNineInput);
                    if(isEmpty(z9)) {
                        z9.setText("0");
                    }

                    TextView z1reps = (TextView) findViewById(R.id.textView2);
                    TextView z2reps = (TextView) findViewById(R.id.textView3);
                    TextView z3reps = (TextView) findViewById(R.id.textView4);
                    TextView z4reps = (TextView) findViewById(R.id.textView5);
                    TextView z5reps = (TextView) findViewById(R.id.textView6);
                    TextView z6reps = (TextView) findViewById(R.id.textView7);
                    TextView z7reps = (TextView) findViewById(R.id.textView8);
                    TextView z8reps = (TextView) findViewById(R.id.textView9);
                    TextView z9reps = (TextView) findViewById(R.id.textView10);

                    // array to store user-input values
                    int[] inputField = new int[] {
                            Integer.parseInt(z1.getText().toString()),
                            Integer.parseInt(z2.getText().toString()),
                            Integer.parseInt(z3.getText().toString()),
                            Integer.parseInt(z4.getText().toString()),
                            Integer.parseInt(z5.getText().toString()),
                            Integer.parseInt(z6.getText().toString()),
                            Integer.parseInt(z7.getText().toString()),
                            Integer.parseInt(z8.getText().toString()),
                            Integer.parseInt(z9.getText().toString())
                    };

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
                            (double) inputField[0] / reps[0],
                            (double) inputField[1] / reps[1],
                            (double) inputField[2] / reps[2],
                            (double) inputField[3] / reps[3],
                            (double) inputField[4] / reps[4],
                            (double) inputField[5] / reps[5],
                            (double) inputField[6] / reps[6],
                            (double) inputField[7] / reps[7],
                            (double) inputField[8] / reps[8]
                    };

                    // the user’s goal for efficiency in each zone (50% to start with)
                    double goal = 0.5;

                    // check the efficiencies for each zone and adjust them accordingly
                    for(int i = 0; i < 9; i++)
                    {
                        // if current zone efficiency is below target (goal) efficiency
                        if(Double.compare(zoneEff[i], goal) < 0)
                        {
                            // increase reps for that zone by the same % goal efficiency
                            reps[i] = (int) (reps[i] + (reps[i] * goal));

                            // decrease reps for other zones by 1 if they're already hitting the target efficiency
                            // otherwise keep them the same until their reps are increased or if their reps already have been increased
                            for(int j = 0; j < 9; j++)
                            {
                                // if the efficiency of the zone is greater than or equal to the goal efficiency
                                if(Double.compare(zoneEff[j], goal) >= 0)
                                {
                                    reps[j] = reps[j] - 2;
                                } // end if
                            } // end inner for-loop
                        } // end if
                    } // end outer for-loop

                    // edit text fields to display the adjusted reps for each zone
                    // rep counts should be no higher than 20 and no lower than 5
                    String[] newText = new String[9];
                    String FILENAME = "baseballRepsFile";
                    String temp; // string to hold new rep totals + end line
                    FileOutputStream fos = null;
                    try {
                        fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    for(int h = 0; h < 9; h++)
                    {
                        if (reps[h] <= 20 && reps[h] >= 5)
                        {
                            newText[h] = Integer.toString(reps[h]);
                            temp = newText[h] + "\n";
                            try {
                                fos.write(temp.getBytes());
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        else if(reps[h] > 20)
                        {
                            newText[h] = "20";
                            temp = newText[h] + "\n";
                            try {
                                fos.write(temp.getBytes());
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else if(reps[h] < 5)
                        {
                            newText[h] = "5";
                            temp = newText[h] + "\n";
                            try {
                                fos.write(temp.getBytes());
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // update textView fields in the GUI to reflect the new rep values for each zone
                    z1reps.setText(newText[0]);
                    z2reps.setText(newText[1]);
                    z3reps.setText(newText[2]);
                    z4reps.setText(newText[3]);
                    z5reps.setText(newText[4]);
                    z6reps.setText(newText[5]);
                    z7reps.setText(newText[6]);
                    z8reps.setText(newText[7]);
                    z9reps.setText(newText[8]);

                    z1.setText("");
                    z2.setText("");
                    z3.setText("");
                    z4.setText("");
                    z5.setText("");
                    z6.setText("");
                    z7.setText("");
                    z8.setText("");
                    z9.setText("");

                } // end onClick
            }); // end setOnClickListener
        } // end if(submit != null)
    } // end onCreate

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    } // end onCreateOptionsMenu*/
}
