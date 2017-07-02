package com.example.carolpesena.watchdogsapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import android.os.Vibrator;

/**
 * Created by PPGEB on 20/06/2017.
 */

public class BackgroundTask extends AsyncTask <String, Void, Void> {
    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx = ctx;
    }

    public BackgroundTask() {
        Log.d("back", "construtora");
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

//        Vibrator v = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 400 milliseconds
//        v.vibrate(400);

        Log.d("back", "onPreExecute");
    }

    @Override
    protected Void doInBackground(String... params) {

        String agendar_url = "";

        String metodo = params[0];

        if(metodo.equals("agendar"))
        {
            String dth_agendamento = params[1];
            String dth_desagendamento = params[2];
            Log.d("back", "agendar!");

            agendar(dth_agendamento,dth_desagendamento);

        }

        if(metodo.equals("configurar"))
        {
            Log.d("back", "configurar!");

            String sensor_1 = params[1];
            String sensor_2 = params[2];
            String sensor_3 = params[3];
            String sensor_4 = params[4];
            String sensor_5 = params[5];
            String sensor_6 = params[6];




           configurar(sensor_1, sensor_2, sensor_3, sensor_4, sensor_5, sensor_6);

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Log.d("back", "onProgressUpdate");

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("back", "onPostExecute");

    }

    protected String agendar(String dth_agendamento, String dth_desagendamento)
    {
        String status = null;

        Connection connection = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");//seleciona Driver

            // Carregando o JDBC Driver padrão

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);



            // Configurando a nossa conexão com um banco de dados//

            String serverName = "10.15.2.177:3306";    //caminho do servidor do BD

            String mydatabase ="wdp";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";        //nome de um usuário de seu BD

            String password = "watchdogs";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);




            //Testa sua conexão//

            if (connection != null)
            {

                status = ("STATUS--->Conectado com sucesso!");
                Log.i("retrieveserver", status);

                Statement st = connection.createStatement();
                Log.i("retrieveserver", "criei statement");
//                    String sql = ("SELECT id, login, password FROM users;");
                String sql = ("INSERT INTO agendamento (data_ativ, data_desativ) VALUES ('2017-05-23T14:25:10', '2018-05-23T14:25:10');");
                Log.i("retrieveserver", "fiz string");
                try {
                    int rs = st.executeUpdate(sql);
                    Log.i("hot dog", Integer.toString(rs) );

                        /*if(rs.next()) {
                            Log.i("retrieveserver", "entrei no if");
                            int id = rs.getInt(1);
//                        String str1 = rs.getString(2);
                            Log.i("olha a desgraça", rs.getString(1));
                            Log.i("olha a desgraça", rs.getString(2));
                            Log.i("olha a desgraça", rs.getString(3));
                            Log.i("retrieveserver", "maoooooo");
                            Log.i("retrieveserver", rs.getString(2));
                        }
                        Log.i("retrieveserver", "vou fechar a connection");
                        connection.close();
                        Log.i("retrieveserver", "Fechei a conexão");
*/
//                    Log.i()
                }
                catch(Exception e)
                {
                    Log.i("erro... ", e.toString());
                }
                Log.i("retrieveserver", "fiz query");


            }
            else
            {

                status = ("STATUS--->Não foi possivel realizar conexão");
                Log.i("retrieveserver", status);


            }



            return "1";



        } catch (ClassNotFoundException e) {  //Driver não encontrado



            System.out.println("O driver especificado nao foi encontrado.");
            System.out.println(e.toString());

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco

            System.out.println("Nao foi possivel conectar ao banco de dados.");

            return null;

        }
    }    protected String configurar(String sens_1, String sens_2, String sens_3, String sens_4, String sens_5, String sens_6)
    {
        String status = null;

        int sensor_1;
        int sensor_2;
        int sensor_3;
        int sensor_4;
        int sensor_5;
        int sensor_6;

        Log.d("olha", sens_1);

        if (sens_1 == "false")
        {
            sensor_1 = 0;
        }
        else{
            sensor_1 = 1;
        }
        if (sens_2 == "false")
        {
            sensor_2 = 0;
        }
        else{
            sensor_2 = 1;
        }
        if (sens_3 == "false")
        {
            sensor_3 = 0;
        }
        else{
            sensor_3 = 1;
        }
        if (sens_4 == "false")
        {
            sensor_4 = 0;
        }
        else{
            sensor_4 = 1;
        }
        if (sens_5 == "false")
        {
            sensor_5 = 0;
        }
        else{
            sensor_5 = 1;
        }
        if (sens_6 == "false")
        {
            sensor_6 = 0;
        }
        else{
            sensor_6 = 1;
        }

        Connection connection = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");//seleciona Driver

            // Carregando o JDBC Driver padrão

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);



            // Configurando a nossa conexão com um banco de dados//

            String serverName = "10.15.2.177:3306";    //caminho do servidor do BD

            String mydatabase ="wdp";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";        //nome de um usuário de seu BD

            String password = "watchdogs";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);




            //Testa sua conexão//

            if (connection != null)
            {

                status = ("STATUS--->Conectado com sucesso!");
                Log.i("retrieveserver", status);

                Statement st = connection.createStatement();
                Log.i("retrieveserver", "criei statement");
//                    String sql = ("SELECT id, login, password FROM users;");
                String sql1 = (

                "UPDATE sensors SET status = "+Integer.toString(sensor_1)+" WHERE id = 5;"


                        );
                String sql2 = (

                "UPDATE sensors SET status = "+Integer.toString(sensor_2)+" WHERE id = 6;"


                        );
                String sql3 = (

                "UPDATE sensors SET status = "+Integer.toString(sensor_3)+" WHERE id = 7;"


                        );
                String sql4 = (

                "UPDATE sensors SET status = "+Integer.toString(sensor_4)+" WHERE id = 8;"
                        );
                String sql5 = (

                "UPDATE sensors SET status = "+Integer.toString(sensor_5)+" WHERE id = 9;"
                        );
                String sql6 = (

                "UPDATE sensors SET status = "+Integer.toString(sensor_6)+" WHERE id = 10;"
                        );


//                        ("INSERT INTO sensors (id,nome,status, pin) VALUES ('5','janela1',1 ,'17'),('6','janela2',3 ,'27'),('7','janela3',3 ,'22'),('8','sala1',12,'14'),('9','quarto1',12,'15'),('10','quarto2',12,'18')" +
//                        "ON DUPLICATE KEY UPDATE nome=VALUES(nome),status=VALUES(status),pin=VALUES(pin);");


//                        "UPDATE sensors (id, nome, status, pin) VALUES ('5','janela1', '"+sensor_1+"', '17'), " +
//                        "('6','janela2', '"+sensor_2+"', '27'),  " +
//                        "('7','janela3', '"+sensor_3+"', '22'), " +
//                        "('8','sala1',   '"+sensor_4+"', '14'), " +
//                        "('9','quarto1', '"+sensor_5+"', '15') , " +
//                        "('10','quarto2', '"+sensor_6+"', '18');");
//                        "INSERT INTO sensors (nome, status) VALUES ('janela2', '"+sensor_2+"'); " +
//                        "INSERT INTO sensors (nome, status) VALUES ('janela3', '"+sensor_3+"'); " +
//                        "INSERT INTO sensors (nome, status) VALUES ('sala1',   '"+sensor_4+"'); " +
//                        "INSERT INTO sensors (nome, status) VALUES ('quarto1', '"+sensor_5+"'); " +
//                        "INSERT INTO sensors (nome, status) VALUES ('quarto2', '"+sensor_6+"'); " +

//                        "");
                Log.i("retrieveserver", "fiz string");
                try {
                    int rs = st.executeUpdate(sql1);
                    Log.i("hot dog", Integer.toString(rs) );
                }
                catch(Exception e)
                {
                    Log.i("erro... ", e.toString());
                }

                try {
                    int rs = st.executeUpdate(sql2);
                    Log.i("hot dog", Integer.toString(rs) );
                }
                catch(Exception e)
                {
                    Log.i("erro... ", e.toString());
                }
                try {
                    int rs = st.executeUpdate(sql3);
                    Log.i("hot dog", Integer.toString(rs) );
                }
                catch(Exception e)
                {
                    Log.i("erro... ", e.toString());
                }
                try {
                    int rs = st.executeUpdate(sql4);
                    Log.i("hot dog", Integer.toString(rs) );
                }
                catch(Exception e)
                {
                    Log.i("erro... ", e.toString());
                }
                try {
                    int rs = st.executeUpdate(sql5);
                    Log.i("hot dog", Integer.toString(rs) );
                }
                catch(Exception e)
                {
                    Log.i("erro... ", e.toString());
                }
                try {
                    int rs = st.executeUpdate(sql6);
                    Log.i("hot dog", Integer.toString(rs) );
                }
                catch(Exception e)
                {
                    Log.i("erro... ", e.toString());
                }

                Log.i("retrieveserver", "fiz query");


            }
            else
            {

                status = ("STATUS--->Não foi possivel realizar conexão");
                Log.i("retrieveserver", status);


            }



            return "1";



        } catch (ClassNotFoundException e) {  //Driver não encontrado



            System.out.println("O driver especificado nao foi encontrado.");
            System.out.println(e.toString());

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco

            System.out.println("Nao foi possivel conectar ao banco de dados.");

            return null;

        }
    }
}
