package com.example.carolpesena.watchdogsapp;

import android.app.TimePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();


    private Button mPickDate;
    private int mYear;
    private int mMonth;
    private int mDay;
    static final int DATE_DIALOG_ID = 0;

    private String DTH_ativacao;
    private String DTH_desativacao;

    private TextView tvDisplayTime;
    private TimePicker timePicker1;
    private Button btnChangeTime;

    private int hour;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);



        TimePicker timePicker = (TimePicker) findViewById(R.id.activation_time);
        timePicker.setCurrentHour(12);
        timePicker.setCurrentMinute(15);


        TimePicker timePicker2 = (TimePicker) findViewById(R.id.deactivation_time);
        timePicker2.setCurrentHour(16);
        timePicker2.setCurrentMinute(21);


        this.mViewHolder.buttonSchedule = (Button) findViewById(R.id.button_save_schedule);
//        this.mViewHolder.tempoativ = (TimePicker) findViewById(R.id.activation_time);
        this.mViewHolder.tempodesativ = (TimePicker) findViewById(R.id.deactivation_time);

        this.mViewHolder.buttonSchedule.setOnClickListener(this);
//        this.mViewHolder.tempoativ.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) { Log.d("oi", "oi"); }
//        });
        this.mViewHolder.tempodesativ.setOnClickListener(this);


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                updateDisplay(hourOfDay, minute);
                Log.d("timelistener", "aaaaaaah lelek");
//                Log.d("timelistener", Integer.toString(hourOfDay));
//                Log.d("timelistener", Integer.toString(minute));

                DTH_ativacao = Integer.toString(hourOfDay)+":"+Integer.toString(minute);
                Log.d("timepicker ativação", DTH_ativacao);




            }
        });

        timePicker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                updateDisplay(hourOfDay, minute);
                Log.d("timelistener2", "aaaaaaah lelek");
                Log.d("timelistener2", Integer.toString(hourOfDay));
                Log.d("timelistener2", Integer.toString(minute));

                DTH_desativacao = Integer.toString(hourOfDay)+":"+Integer.toString(minute);
                Log.d("timepicker desativação", DTH_desativacao);






            }
        });


        setCurrentTimeOnView();
        addListenerOnButton();












    }
//
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        switch (id) {
//            case TIME_DIALOG_ID:
//                // set time picker as current time
//                return new TimePickerDialog(this,
//                        timePickerListener, hour, minute,false);
//
//        }
//        return null;
//    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        Log.i("onClick", "clicou em alguma coisa no scheduler");

        if(id == R.id.button_save_schedule){


            Log.i("onClick", "clicou para voltar");




            super.onBackPressed();
        }

        if(id == R.id.activation_time){


            Log.i("onClick", "selecionou ativacao");
        }

        if(id == R.id.deactivation_time){


            Log.i("onClick", "selecionou desativacao");
        }
    }


    public void setCurrentTimeOnView() {

////        tvDisplayTime = (TextView) findViewById(R.id.tvTime);
//        timePicker1 = (TimePicker) findViewById(R.id.activation_time);
//
//        final Calendar c = Calendar.getInstance();
//        hour = c.get(Calendar.HOUR_OF_DAY);
//        minute = c.get(Calendar.MINUTE);
//
//        // set current time into textview
////        tvDisplayTime.setText(
////                new StringBuilder().append(pad(hour))
////                        .append(":").append(pad(minute)));
//
//        // set current time into timepicker
//        timePicker1.setCurrentHour(10);
//        timePicker1.setCurrentMinute(15);

    }




    public void addListenerOnButton() {

        btnChangeTime = (Button) findViewById(R.id.button_save_schedule);

        btnChangeTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.d("clicou", "clicou no agendamento");

                String metodo = "agendar";

                BackgroundTask backgroundtask = new BackgroundTask();
                backgroundtask.execute(metodo, DTH_ativacao, DTH_desativacao);






            }

        });

    }

//
//    private TimePickerDialog.OnTimeSetListener timePickerListener =
//            new TimePickerDialog.OnTimeSetListener() {
//                public void onTimeSet(TimePicker view, int selectedHour,
//                                      int selectedMinute) {
//                    hour = selectedHour;
//                    minute = selectedMinute;
//
//                    // set current time into textview
//                    tvDisplayTime.setText(new StringBuilder().append(pad(hour))
//                            .append(":").append(pad(minute)));
//
//                    // set current time into timepicker
//                    timePicker1.setCurrentHour(hour);
//                    timePicker1.setCurrentMinute(minute);
//
//                }
//            };


    public int GravaDados()
    {




        int a = 0;

        return a;
    }

    static class ViewHolder{
        Button buttonSchedule;
        TimePicker tempoativ;
        TimePicker tempodesativ;
    }
}
