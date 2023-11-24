package com.teste.mvvmcep.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.Snackbar;
import com.teste.mvvmcep.R;
import com.teste.mvvmcep.model.Cep;

import java.util.List;

public class CepAdapter extends RecyclerView.Adapter<CepHolder> {
    private final List<Cep> cepList;

    public CepAdapter(List<Cep> cepList) {
        this.cepList = cepList;
    }

    @NonNull
    @Override
    public CepHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CepHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CepHolder holder, int position) {
        holder.cep_textview.setText(cepList.get(position).cep);
        holder.button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "Depois eu arrumo essa porra!", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return cepList != null ? cepList.size() : 0;
    }

    public void addCep(Cep cep) {
        cepList.add(0, cep);
        notifyItemInserted(0);
    }

    public void removeCep(Cep cep) {
        int position = cepList.indexOf(cep);
        cepList.remove(position);
        notifyItemRemoved(position);
    }
}

class CepHolder extends RecyclerView.ViewHolder {
    public TextView cep_textview;
    public ImageButton button_search;
    public Chip chip_delete;

    public CepHolder(@NonNull View itemView) {
        super(itemView);
        cep_textview = itemView.findViewById(R.id.cep_text_view);
        button_search = itemView.findViewById(R.id.search_button);
        chip_delete = itemView.findViewById(R.id.chip_delete);

    }
}
