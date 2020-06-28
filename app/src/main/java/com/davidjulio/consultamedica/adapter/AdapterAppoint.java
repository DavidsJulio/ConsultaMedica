package com.davidjulio.consultamedica.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.davidjulio.consultamedica.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterAppoint extends RecyclerView.Adapter<AdapterAppoint.AppointViewHolder> {

    private Context aContext;
    private Cursor aCursor;

    public AdapterAppoint(Context context, Cursor cursor) {
        aContext = context;
        aCursor = cursor;
    }

    @NonNull
    @Override
    public AppointViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listAppoint = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_appoint, parent, false);
        return new AppointViewHolder( listAppoint );
    }


    @Override
    public void onBindViewHolder(@NonNull AppointViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AppointViewHolder extends RecyclerView.ViewHolder {

        TextView  tvAppointDate, tvAppointHour, tvPatientID, tvPatientName, tvPatientResult;
        public AppointViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAppointDate = itemView.findViewById(R.id.tvAppointDate);
            tvAppointHour = itemView.findViewById(R.id.tvAppointHour);
            tvPatientID = itemView.findViewById(R.id.tvPatientID);
            tvPatientName = itemView.findViewById(R.id.tvPatientName);
            tvPatientResult = itemView.findViewById(R.id.tvPatientResult);
        }
    }

}
