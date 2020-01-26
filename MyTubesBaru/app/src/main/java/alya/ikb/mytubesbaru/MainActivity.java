package alya.ikb.mytubesbaru;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

import alya.ikb.mytubesbaru.adapter.ListNoteAdapter;
import alya.ikb.mytubesbaru.helper.DataHelper;
import alya.ikb.mytubesbaru.model.NoteModel;

public class MainActivity extends AppCompatActivity {
    private ArrayList<NoteModel> list = new ArrayList<>();
    DataHelper SQLite = new DataHelper(this);
    FloatingActionButton fbbuat;

    RecyclerView rv_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_note = findViewById(R.id.recycler);
        rv_note.setHasFixedSize(true);

        fbbuat = findViewById(R.id.btn_buat);
        fbbuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InputDataActivity.class));
            }
        });

        getAllData();

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientactionbar));
        }
    }

    private void getAllData(){
        rv_note.setLayoutManager(new LinearLayoutManager(this));
        ListNoteAdapter listNoteAdapter = new ListNoteAdapter(list);
        rv_note.setAdapter(listNoteAdapter);

        ArrayList<HashMap<String, Object>> row = SQLite.GetAllData();

        for (int i =0; i<row.size(); i++){
            Integer id = (Integer) row.get(i).get(DataHelper.COLUMN_ID);
            String title = (String) row.get(i).get(DataHelper.COLUMN_TITLE);
            String date = (String) row.get(i).get(DataHelper.COLUMN_DATE);
            String note = (String) row.get(i).get(DataHelper.COLUMN_NOTE);

            NoteModel data = new NoteModel();

            data.setId(id);
            data.setTitle(title);
            data.setDate(date);
            data.setNote(note);

            list.add(data);
        }

        listNoteAdapter.notifyDataSetChanged();

        listNoteAdapter.setOnItemClickCallback(new ListNoteAdapter.OnItemClickCallback() {
            @Override
            public void onItemClick(NoteModel data) {
                NoteModel model = new NoteModel();
                model.setId(data.getId());
                model.setTitle(data.getTitle());
                model.setDate(data.getDate());
                model.setNote(data.getNote());
                Intent i = new Intent(MainActivity.this,
                        DetailDataActivity.class)
                        .putExtra(DetailDataActivity.EXTRA_DATA, model);
                startActivity(i);
            }
        });

        listNoteAdapter.setOnItemHoldCallback(new ListNoteAdapter.OnItemHoldCallback(){
            @Override
            public void onItemHolded(final NoteModel data) {
                final CharSequence[] dialogitem = {"Lihat Data", "Update Data"
                        , "Hapus Data"};
                AlertDialog.Builder builder = new
                        AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilihan");

                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                NoteModel model = new NoteModel();
                                model.setId(data.getId());
                                model.setTitle(data.getTitle());
                                model.setDate(data.getDate());
                                model.setNote(data.getNote());
                                Intent i = new Intent(MainActivity.this,
                                        DetailDataActivity.class)
                                        .putExtra(DetailDataActivity.EXTRA_DATA, model);
                                startActivity(i);
                                break;
                            case 1:
                                NoteModel NModel = new NoteModel();
                                NModel.setId(data.getId());
                                NModel.setTitle(data.getTitle());
                                NModel.setDate(data.getDate());
                                NModel.setNote(data.getNote());
                                Intent in = new Intent(MainActivity.this,
                                        UpdateDataActivity.class)
                                        .putExtra(UpdateDataActivity.EXTRA_DATA, NModel);
                                startActivity(in);
                                break;
                            case 2:
                                DataHelper SQlite = new DataHelper(MainActivity.this);
                                SQlite.delete(data.getId());
                                list.clear();
                                getAllData();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

    }
}
