package mchong.cs430app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ImageButton basketballImageButton = (ImageButton) findViewById(R.id.basketballButton);

        basketballImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Intent is what you use to start another activity
                Intent intent = new Intent(MainMenu.this, basketballMenu.class);
                startActivity(intent);
            }
        });
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(myIntent, 0);
        return true;

    }*/
}
