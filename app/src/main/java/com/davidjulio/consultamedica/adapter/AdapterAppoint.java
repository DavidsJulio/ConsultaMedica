package com.davidjulio.consultamedica.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull AppointViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AppointViewHolder extends RecyclerView.ViewHolder {

        public AppointViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
