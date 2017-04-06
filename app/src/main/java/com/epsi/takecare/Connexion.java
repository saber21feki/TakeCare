package com.epsi.takecare;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;


import static com.epsi.takecare.R.id.Identifiant;
import static com.epsi.takecare.R.id.MotDePasse;
import static com.epsi.takecare.R.id.buttonConnexion;
import static com.epsi.takecare.R.layout.connexion;

public class Connexion extends AppCompatActivity {

    private Button btnConnexion;
    private EditText etPwd;
    private EditText etId;
    String wsResult="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        etId = (EditText) findViewById(Identifiant);
        etPwd = (EditText) findViewById(MotDePasse);
        btnConnexion = (Button) findViewById(buttonConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(), "Chargement...", Toast.LENGTH_LONG).show();
                (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=auth&mail="+etId.getText()+"&mdp="+etPwd.getText());




                //SystemClock.sleep(7000);


                if (Integer.parseInt(wsResult)>0){
                        Constante.Id_CM = wsResult;
                        Toast.makeText(getApplicationContext(), "connexion réussite", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(v.getContext(), ListePatient.class);
                        startActivity(myIntent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Mauvais login", Toast.LENGTH_LONG).show();

                    }



            }
        });
    }


    public class MyAsyncTask extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {

            WS accesWs=new WS();

            return accesWs.getWs(params[0]);
        }



        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);


            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            wsResult=result;


            // Do things like hide the progress bar or change a TextView
        }
    }

    public static class Constante{
        public static String Id_CM;
    }

}
