package com.example.carolpesena.watchdogsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ConfigurationsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder sViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);
        Log.i("onCreate", "criei confingurações");

        this.sViewHolder.buttonSensors = (Button) findViewById(R.id.button_sensors);

        this.sViewHolder.buttonSensors.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.button_sensors){
            Intent intent = new  Intent(this, SensorsActivity.class);
            startActivity(intent);




        }
    }

    public void onToggleClicked(View view) {
    }

    private static class ViewHolder{
        Button buttonSensors;
    }
}
