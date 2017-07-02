package com.example.carolpesena.watchdogsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class SensorsActivity extends AppCompatActivity implements View.OnClickListener{


    private ViewHolder kViewHolder = new ViewHolder();

    String teste[] = new String[7];



    public String[] getSensores() {
        return teste;
    }

    CheckBox satView1;
    CheckBox satView2;
    CheckBox satView3;
    CheckBox satView4;
    CheckBox satView5;
    CheckBox satView6;


    boolean chk1;
    boolean chk2;
    boolean chk3;
    boolean chk4;
    boolean chk5;
    boolean chk6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        satView1 = (CheckBox)findViewById(R.id.check_livingroomwindow_sensor);
        satView2 = (CheckBox)findViewById(R.id.check_room1window_sensor);
        satView3 = (CheckBox)findViewById(R.id.check_room2window_sensor);
        satView4 = (CheckBox)findViewById(R.id.check_livingroom_sensor);
        satView5 = (CheckBox)findViewById(R.id.check_room1_sensor);
        satView6 = (CheckBox)findViewById(R.id.check_room2_sensor);


        satView1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {


                                                   chk1 = satView1.isChecked();
                                                   Log.d("mudou", Boolean.toString(chk1));

                                               }
                                           }
        );
        satView2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                   chk2 = satView2.isChecked();
                                                   Log.d("mudou", Boolean.toString(chk2));

                                               }
                                           }
        );
        satView3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                   chk3 = satView3.isChecked();
                                                   Log.d("mudou", Boolean.toString(chk3));

                                               }
                                           }
        );
        satView4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                   chk4 = satView4.isChecked();
                                                   Log.d("mudou", Boolean.toString(chk4));

                                               }
                                           }
        );
        satView5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                   chk5 = satView5.isChecked();
                                                   Log.d("mudou", Boolean.toString(chk5));

                                               }
                                           }
        );
        satView6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                   chk6 = satView6.isChecked();
                                                   Log.d("mudou", Boolean.toString(chk6));

                                               }
                                           }
        );




        this.kViewHolder.ok = (Button) findViewById(R.id.ok);
        this.kViewHolder.ok.setOnClickListener(this);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.putExtra("keyName", "IIIII");
        setResult(RESULT_OK, intent);
        finish();

        Log.d("backback", "backpressed");
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Log.i("onClick", "clicou em alguma coisa nos sensores");

        if(id == R.id.ok){

            String repasse = "";


            Log.i("onClick", "clicou para voltar");
            //manda as infos para o servidor

            String metodo = "configurar";

            if(chk1){

                repasse+="L";
            }
            else
            {
                repasse+="D";
            }
            if(chk2){

                repasse+="L";
            }
            else
            {
                repasse+="D";
            }
            if(chk3){

                repasse+="L";
            }
            else
            {
                repasse+="D";
            }
            if(chk4){

                repasse+="L";
            }
            else
            {
                repasse+="D";
            }
            if(chk5){

                repasse+="L";
            }
            else
            {
                repasse+="D";
            }
            if(chk6){

                repasse+="L";
            }
            else
            {
                repasse+="D";
            }



            teste[0]= Boolean.toString(chk1);
            teste[1]= Boolean.toString(chk2);
            teste[2]= Boolean.toString(chk3);
            teste[3]= Boolean.toString(chk4);
            teste[4]= Boolean.toString(chk5);
            teste[5]= Boolean.toString(chk6);


            Intent intent = new Intent();
            intent.putExtra("keyName", repasse);
            setResult(RESULT_OK, intent);
            finish();

           BackgroundTask backgroundtask = new BackgroundTask();
          backgroundtask.execute(metodo, teste[0], teste[1], teste[2], teste[3], teste[4], teste[5], teste[6]);

            super.onBackPressed();
        }

    }

    private static class ViewHolder{
        Button ok;
//        CheckBox satView1;
    }


}
