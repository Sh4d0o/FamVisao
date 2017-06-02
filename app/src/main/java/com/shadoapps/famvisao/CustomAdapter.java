package com.shadoapps.famvisao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Geral on 03/05/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<ListPiece> listPieces;
    private Context context;

    public CustomAdapter(List<ListPiece> listPieces, Context context) {
        this.listPieces = listPieces;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_piece, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListPiece myPiece = listPieces.get(position);

        holder.txtTitle.setText(myPiece.getTitle());
        holder.txtDeadline.setText(myPiece.getDeadline());
        holder.txtState.setText(myPiece.getState());
    }

    @Override
    public int getItemCount() {
        return listPieces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitle, txtDeadline, txtState;

        public ViewHolder(View itemView){
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.piece_title);
            txtDeadline = (TextView) itemView.findViewById(R.id.piece_deadline);
            txtState = (TextView) itemView.findViewById(R.id.piece_state);
        }
    }
}
