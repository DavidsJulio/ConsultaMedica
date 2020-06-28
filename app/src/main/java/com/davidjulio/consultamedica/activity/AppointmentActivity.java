package com.davidjulio.consultamedica.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.davidjulio.consultamedica.AddAppointActivity;
import com.davidjulio.consultamedica.R;

public class AppointmentActivity extends AppCompatActivity {

    RecyclerView recyclerViewAppoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        recyclerViewAppoint = (RecyclerView) findViewById(R.id.recyclerViewAppoint);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.mAdd){
            Intent intentAddAppoint = new Intent(this, AddAppointActivity.class);
            startActivity(intentAddAppoint);
        }

        return super.onOptionsItemSelected(item);
    }
}
