package com.fzain.akupintar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fzain.akupintar.Database;
import com.fzain.akupintar.Model.UniversitasModel;
import com.fzain.akupintar.R;
import com.fzain.akupintar.UniversitasProfil;

import java.util.ArrayList;
import java.util.List;



public class UniversitasAdapter extends RecyclerView.Adapter<UniversitasAdapter.ViewHolder> {
    private Database db;
    private Context context;
    private List<UniversitasModel> univer;

    public UniversitasAdapter(Context context) {
        this.context = context;
        this.univer = new ArrayList<>();
    }

    public void setUniver(List<UniversitasModel> univer) {
        this.univer = univer;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_universitas, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Integer[] kampus = {R.drawable.soekarno, R.drawable.meryriana, R.drawable.jokowi, R.drawable.stevejobs, R.drawable.jokowi};
        final UniversitasModel universitasModel = univer.get(i);

        viewHolder.tvNama.setText(universitasModel.getNamaUniversitas());
        viewHolder.tvAkreditas.setText(universitasModel.getAkreditas());
        viewHolder.tvStatus.setText(universitasModel.getStatus());

        final int idx = universitasModel.getId();
        viewHolder.ivlogo.setImageResource(kampus[idx-1]);

        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UniversitasProfil.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return univer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvNama, tvAkreditas, tvStatus;
        ImageView ivlogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItem = itemView.findViewById(R.id.cv_item);
            tvNama = itemView.findViewById(R.id.tv_title);
            tvAkreditas = itemView.findViewById(R.id.tv_akreditas);
            tvStatus = itemView.findViewById(R.id.tv_status);
            ivlogo = itemView.findViewById(R.id.logo);


        }
    }
}
