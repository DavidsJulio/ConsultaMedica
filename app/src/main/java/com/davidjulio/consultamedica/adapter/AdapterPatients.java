package com.davidjulio.consultamedica.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPatients extends RecyclerView.Adapter <AdapterPatients.MyViewHolder> {
    //recebe uma viewHolder (os itens que passam no recyclerView são exibidos numa ViewHolder)
    //o recycler view tem a função de reciclar as visualizações

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //criar as visualizações


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //exibe os elementos das visualizações

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView namePatient, phonePatient, bDatePatient, cityPatient, resultPatient;

        public MyViewHolder(@NonNull View itemView) { //construtor criado automáticamente
            super(itemView);
        }
   }
}
