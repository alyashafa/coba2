package alya.ikb.mytubesbaru.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import alya.ikb.mytubesbaru.DetailDataActivity;
import alya.ikb.mytubesbaru.MainActivity;
import alya.ikb.mytubesbaru.R;
import alya.ikb.mytubesbaru.UpdateDataActivity;
import alya.ikb.mytubesbaru.helper.DataHelper;
import alya.ikb.mytubesbaru.model.NoteModel;

public class ListNoteAdapter extends RecyclerView.Adapter<ListNoteAdapter.ListViewHolder> {

    private ArrayList <NoteModel> listnote;
    private OnItemHoldCallback onItemHoldCallback;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemHoldCallback(OnItemHoldCallback onItemHoldCallback){
        this.onItemHoldCallback=onItemHoldCallback;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback=onItemClickCallback;
    }

    public interface OnItemClickCallback{
        void onItemClick(NoteModel data);
    }

    public interface OnItemHoldCallback{
        void onItemHolded(NoteModel data);
    }

    public ListNoteAdapter(ArrayList<NoteModel> List){
        this.listnote = List;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView no_note, jdl_note, tgl_note, isi_note, id_note;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            no_note = itemView.findViewById(R.id.no_note);
            jdl_note = itemView.findViewById(R.id.jdl_note);
            tgl_note = itemView.findViewById(R.id.tgl_note);
            isi_note = itemView.findViewById(R.id.isi_note);
            id_note = itemView.findViewById(R.id.tview_id);
        }
    }
    @NonNull
    @Override
    public ListNoteAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_note, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListNoteAdapter.ListViewHolder holder, final int position) {
        final NoteModel noteModel = listnote.get(position);

        holder.no_note.setText(String.valueOf(position + 1));
        holder.jdl_note.setText(noteModel.getTitle());
        holder.isi_note.setText(noteModel.getNote());
        holder.tgl_note.setText(noteModel.getDate());
        holder.id_note.setText(String.valueOf(noteModel.getId()));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                onItemHoldCallback.onItemHolded(listnote.get(holder.getAdapterPosition()));

                return false;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClick(listnote.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listnote.size();
    }
}
