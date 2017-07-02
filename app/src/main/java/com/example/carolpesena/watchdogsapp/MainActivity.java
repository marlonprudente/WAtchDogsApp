package com.example.carolpesena.watchdogsapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;
    ToggleButton toggleButton;
    String returnString = "DDDDDD";

    NotificationManager notificationManager;

    boolean isNotificActive = false;

    int notifID = 33;



//    public String

    private ViewHolder mViewHolder = new ViewHolder();

    public String [] set_status_sensores = new String[7];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.buttonConfiguration = (Button) findViewById(R.id.button_configurations);
        this.mViewHolder.buttonSchedule = (Button) findViewById(R.id.button_schedule);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);

        this.mViewHolder.buttonSchedule.setOnClickListener(this);
        this.mViewHolder.buttonConfiguration.setOnClickListener(this);
//        this.mViewHolder.toggleButton.setOnClickListener(this);

        set_status_sensores[0] = "undefined";
        set_status_sensores[1] = "undefined";
        set_status_sensores[2] = "undefined";
        set_status_sensores[3] = "undefined";
        set_status_sensores[4] = "undefined";
        set_status_sensores[5] = "undefined";

        Log.i("onCreate", "criei");

        try
        {

            Log.i("try", "try");

        } catch (Exception ex)
        {

        }



    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Log.i("onClick", "clicou em alguma coisa");

        if(id == R.id.button_configurations){
            Intent intent = new  Intent(this, SensorsActivity.class);
            startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
            Log.i("onClick", "clicou em configurar");
//            startActivity(intent);
        }

        if(id == R.id.button_schedule){
            Intent intent = new  Intent(this, ScheduleActivity.class);
            Log.i("onClick", "clicou em agendar");
            startActivity(intent);
        }
        if(id == R.id.toggleButton){
            Intent intent = new  Intent(this, ScheduleActivity.class);
            Log.i("onClick", "clicou em togglear estado");

            showNotification();


//            if(R.id.toggleButton.isChecked())
//            {
//
//            }
//            startActivity(intent);
        }




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("main", "voltamos");


        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_RESULT_CODE) {
            Log.d("main", "voltamos aqui");
            Log.d("hello resultCode", Integer.toString(resultCode));
//            if (resultCode == RESULT_OK) {
            if (resultCode == -1) {
                Log.d("voltei olha no que deu", "ok");

                // get String data from Intent
                returnString= data.getStringExtra("keyName");

                // set text view with string
//                TextView textView = (TextView) findViewById(R.id.textView);
                Log.d("voltei olha no que deu", returnString);
            }

            if (resultCode == 0) {
                Log.d("voltei olha no que deu", "ok");

                // get String data from Intent
                String returnString = data.getStringExtra("keyName");

                // set text view with string
//                TextView textView = (TextView) findViewById(R.id.textView);
                Log.d("voltei olha no que deu", returnString);
            }
        }
    }

    public void showNotification ()
    {
        NotificationCompat.Builder notificBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Mensagem")
                .setContentText("Alarme foi disparado!! ")
                .setSmallIcon(R.drawable.ic_action_name)
                .setTicker("Alerta, nova mensagem");

        Log.d("showNotification", "not");

        Intent moreInfoIntent = new Intent(this, MoreInfoNotification.class);
        Log.d("showNotification", "criei intent");

        TaskStackBuilder tStackBuilder = TaskStackBuilder.create(this);
        tStackBuilder.addParentStack(MoreInfoNotification.class);
        tStackBuilder.addNextIntent(moreInfoIntent);
        PendingIntent pendingIntent = tStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        notificBuilder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notifID, notificBuilder.build());
        isNotificActive = true;




    }

    public void interpretaretornointent (String retorno)
    {
        Log.d("interpretar", retorno);


        for (int i = 0; i<=5; i++){
            Log.d("inter", "vai travar?");
            Log.d("inter",String.valueOf(retorno.charAt(i)));
            if (String.valueOf(retorno.charAt(i)) == "D")
            {
                set_status_sensores[i] = "false";
                Log.d("achei um false", "false");
            }
            else if (String.valueOf(retorno.charAt(i)) == "L")
            {
                set_status_sensores[i] = "true";
                Log.d("achei um tue", "true");

            }

        }
    }

    public void onToggleClicked(View view) {

        String metodo = "configurar";

        showNotification();

//        Log.d("toggle", "cliquie");
        if(toggleButton.isChecked())
        {
//            Toast.makeText(MainActivity.this, "Toggle button is on", Toast.LENGTH_LONG).show();
            Log.d("toggle", "sistema ativado");



            interpretaretornointent(returnString);

            BackgroundTask backgroundtask = new BackgroundTask();

            Log.d("teste", set_status_sensores[0]);
            Log.d("teste", set_status_sensores[1]);
            Log.d("teste", set_status_sensores[2]);
            Log.d("teste", set_status_sensores[3]);
            Log.d("teste", set_status_sensores[4]);
            Log.d("teste", set_status_sensores[5]);


           backgroundtask.execute(metodo, set_status_sensores[0],set_status_sensores[1],set_status_sensores[2],set_status_sensores[3],set_status_sensores[4],set_status_sensores[5]);


        }
        else {
//            Toast.makeText(MainActivity.this, "Toggle button is Off", Toast.LENGTH_LONG).show();
            Log.d("toggle", "sistema desativado");

            BackgroundTask backgroundtask = new BackgroundTask();
            backgroundtask.execute(metodo, "false", "false", "false", "false", "false", "false", "false");

        }


    }

    static class ViewHolder{
        Button buttonConfiguration;
        Button buttonSchedule;
        ToggleButton toggleButton;
    }
}
