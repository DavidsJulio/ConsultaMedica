package com.davidjulio.consultamedica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.davidjulio.consultamedica.R;
import com.davidjulio.consultamedica.model.Patient;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPatients extends RecyclerView.Adapter <AdapterPatients.MyViewHolder> {
    //recebe uma viewHolder (os itens que passam no recyclerView são exibidos numa ViewHolder)
    //o recycler view tem a função de reciclar as visualizações

    private List<Patient> patientList;
    public AdapterPatients(List<Patient> patients) { //constructor automatico generate - constructor

        this.patientList = patients;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //criar as visualizações
                                                                                             //parent é o compontente onde a nossa list se encontra
        View listPatients = LayoutInflater.from(parent.getContext())                         //converter um xml em uma View
                            .inflate(R.layout.adapter_patients, parent, false); //vamos buscar o nosso xml

        return new MyViewHolder( listPatients ); //retornar a nossa classe MyViewHolder um parametro View (itemLista)
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //exibe os elementos das visualizações

        //TODO: ligar o on bind à bd
        Patient patient = patientList.get(position);

        holder.namePatient.setText(patient.getNamePatient());
        holder.phonePatient.setText(patient.getPhonePatient());
        holder.bDatePatient.setText(patient.getbDatePatient());
        holder.cityPatient.setText(patient.getCityPatient());
        holder.resultPatient.setText(patient.getResultPatient());

    }

    @Override
    public int getItemCount() { //quantidade de items da recyclerView

        return this.patientList.size(); //quantidade de itens dentro da lista
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView namePatient, phonePatient, bDatePatient, cityPatient, resultPatient;

        public MyViewHolder(@NonNull View itemView) { //construtor criado automaticamente
            super(itemView);
                        //precisamos do itemView porque é ele que acessa os componentes (id's)
            namePatient = itemView.findViewById(R.id.tvNomePatient);
            phonePatient = itemView.findViewById(R.id.tvPhonePatient);
            bDatePatient = itemView.findViewById(R.id.tvBdatePatient);
            cityPatient = itemView.findViewById(R.id.tvCityPatient);
            resultPatient = itemView.findViewById(R.id.tvResultPatient);

        }
   }
}
