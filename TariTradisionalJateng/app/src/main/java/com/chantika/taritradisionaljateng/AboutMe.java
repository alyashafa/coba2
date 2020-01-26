package com.chantika.taritradisionaljateng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("About Me");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
