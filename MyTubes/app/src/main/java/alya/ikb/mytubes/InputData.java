package alya.ikb.mytubes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2;
    String edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        dbHelper = new DataHelper(this);
        text1 = findViewById(R.id.input_judul);
        text2 = findViewById(R.id.input_isi);
        ton1 = findViewById(R.id.btn_save);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                edit = text1.getText().toString();
                edit = text2.getText().toString();
                if (edit.isEmpty()){
                    Toast.makeText(getApplicationContext(), "This column can't be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    db.execSQL("insert into mynote(nomor, title, tgl, note)values('" +
                            );
                }
            }
        });
    }
}
