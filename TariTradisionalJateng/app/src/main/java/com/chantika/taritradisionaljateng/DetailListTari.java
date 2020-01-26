package com.chantika.taritradisionaljateng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailListTari extends AppCompatActivity {
    private int tari_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;
    private ArrayList<Tari> listTari = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_tari);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Tari Tradisional Jawa Tengah");
        }

        tari_id = getIntent().getIntExtra("tari_id", 0);
        tvName = findViewById(R.id.nama_tari);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listTari.addAll(TariData.getListData());
        getSupportActionBar().setTitle(listTari.get(tari_id).getName());
        setLayout();
    }

    void setLayout(){
        tvName.setText(listTari.get(tari_id).getName());
        tvDesc.setText(listTari.get(tari_id).getDescription());
        Glide.with(this)
                .load(listTari.get(tari_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }
}

