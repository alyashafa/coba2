package alya.ikb.mytubes;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList noNote;
    private ArrayList jdlNote;
    private ArrayList tglNote;
    private ArrayList isiNote;

    RecyclerViewAdapter(ArrayList noNote,ArrayList jdlNote, ArrayList tglNote, ArrayList isiNote){
        this.noNote =noNote;
        this.jdlNote=jdlNote;
        this.tglNote=tglNote;
        this.isiNote=isiNote;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView No, Title, Date, Notes;

        ViewHolder(View itemView){
            super(itemView);
            No=itemView.findViewById(R.id.no_note);
            Title=itemView.findViewById(R.id.jdl_note);
            Date=itemView.findViewById(R.id.tgl_note);
            Notes=itemView.findViewById(R.id.isi_note);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_note, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView")final int position){
        final String No = (String) noNote.get(position);
        final String Title = (String) jdlNote.get(position);
        final String Date = (String) tglNote.get(position);
        final String Notes = (String) isiNote.get(position);
        holder.No.setText(No);
        holder.Title.setText(Title);
        holder.Date.setText(Date);
        holder.Notes.setText(Notes);
    }

    @Override
    public int getItemCount(){
        return noNote.size();
    }
}
