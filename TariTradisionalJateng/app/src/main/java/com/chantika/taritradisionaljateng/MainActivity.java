package com.chantika.taritradisionaljateng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTari;
    private ArrayList<Tari> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Tari Tradisional Jawa Tengah");
        }

        rvTari = findViewById(R.id.rv_tari);
        rvTari.setHasFixedSize(true);

        list.addAll(TariData.getListData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvTari.setLayoutManager(new LinearLayoutManager(this));
        CardTariAdapter cardTariAdapter = new CardTariAdapter(this, list);
        rvTari.setAdapter(cardTariAdapter);
    }

    //Membuat menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tombol_about, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about_me:
                Intent intent = new Intent(this, AboutMe.class);
                startActivity(intent);
                return true;
        }
        return true;
    }
}
