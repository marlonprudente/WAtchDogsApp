package com.example.carolpesena.watchdogsapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder lViewHolder = new ViewHolder();
    private String status = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.lViewHolder.loginName = (EditText) findViewById(R.id.user_login);
        this.lViewHolder.loginPassword = (EditText) findViewById(R.id.pass_login);
        this.lViewHolder.buttonLogin = (Button) findViewById(R.id.enter_button);
        this.lViewHolder.buttonViewPassword = (CheckBox) findViewById(R.id.show_password);
        this.lViewHolder.buttonSavePassword = (CheckBox) findViewById(R.id.save_password);

        this.lViewHolder.buttonLogin.setOnClickListener(this);
        this.lViewHolder.buttonViewPassword.setOnClickListener(this);
        this.lViewHolder.buttonSavePassword.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.enter_button){


            Intent intent = new  Intent(this, MainActivity.class);

            Log.i("LoginActivity", "clicou no enter button");
            startActivity(intent);
        }

        else if(id == R.id.show_password){

        }

        else if(id == R.id.save_password){

        }

    }

    private class AsyncCon extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... params) {

            Connection connection = null;

            try {
                Class.forName("org.gjt.mm.mysql.Driver");//seleciona Driver

                // Carregando o JDBC Driver padrão

                String driverName = "com.mysql.jdbc.Driver";

                Class.forName(driverName);



                // Configurando a nossa conexão com um banco de dados//

                String serverName = "10.15.2.124:3306";    //caminho do servidor do BD

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
                    String sql = ("INSERT INTO users (id, login, password) VALUES (5, 'hahahaha', '5555');");
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

                System.out.println("Nao foi possivel conectar ao Banco de Dados.");

                return null;

            }



            //return null;
        }
    }

    private static class ViewHolder {
        EditText loginName;
        EditText loginPassword;
        Button buttonLogin;
        CheckBox buttonViewPassword;
        CheckBox buttonSavePassword;
    }
}
