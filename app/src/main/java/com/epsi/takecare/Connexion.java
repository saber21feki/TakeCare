package com.epsi.takecare;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    Intent myIntent;

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        if(Constante.CM != null){
            Constante.CM = new Corps_Medical();
        }

        etId = (EditText) findViewById(Identifiant);
        etPwd = (EditText) findViewById(MotDePasse);
        btnConnexion = (Button) findViewById(buttonConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(isValidEmail(etId.getText())){
                (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=auth&mail="+etId.getText()+"&mdp="+etPwd.getText());
                myIntent = new Intent(v.getContext(), ListePatient.class);
            }
            else{
                Toast.makeText(getApplicationContext(), "Email invalid", Toast.LENGTH_LONG).show();
                etId.setText("");
                etPwd.setText("");
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


            if (Integer.parseInt(result)>0){
                Constante.CM.setId_CM(Integer.parseInt(result));
                Toast.makeText(getApplicationContext(), "connexion réussite", Toast.LENGTH_LONG).show();
                startActivity(myIntent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Mauvais login", Toast.LENGTH_LONG).show();

            }
        }
    }

    public static class Constante{
        public static Corps_Medical CM = new Corps_Medical();
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
