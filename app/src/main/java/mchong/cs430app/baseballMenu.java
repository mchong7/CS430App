package mchong.cs430app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class baseballMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_menu);

        Button baseballRoutineButton = (Button) findViewById(R.id.baseballRoutineButton);
        baseballRoutineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(baseballMenu.this, Main.class);
                startActivity(intent);
            } // end onClick
        }); // end baseballRoutineButton Intent
    } // end onCreate
}
