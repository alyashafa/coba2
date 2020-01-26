package alya.ikb.mytubes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] daftar;
    ListView ListViewNote;
    protected  Cursor cursor;
    DataHelper dbcenter;
    public static MainActivity DN;

    @Override
    protected void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_buat);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent inte = new Intent(MainActivity.this, InputData.class);

                startActivity(inte);
            }
        });

        DN= this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mynote", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0;cc<cursor.getCount();cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListViewNote = (ListView) findViewById(R.id.recycler);
        ListViewNote.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListViewNote.setSelected(true);
        ListViewNote.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3){
                final String selection = daftar [arg2];
                final CharSequence[] dialogitem = {"Note Detail", "Update Note", "Delete Note"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Option");

                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        switch (item){
                            case 0:
                                Intent i = new Intent(getApplicationContext(), DetailData.class);
                                i.putExtra("title", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(),UpdateData.class);
                                in.putExtra("title",selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from mynote where title ='" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) ListViewNote.getAdapter()).notifyDataSetInvalidated();
    }
}
