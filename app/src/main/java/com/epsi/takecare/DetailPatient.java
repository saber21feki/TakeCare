package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gael on 04/04/2017.
 */



public class DetailPatient extends Activity {

    private TextView numSecu;
    private TextView nomPatient;
    private TextView prenomPatient;
    private TextView dateNaissance;
    private TextView adressePatient;

    private TextView telPatient;
    private TextView emailPatient;
    private TextView sexePatient;
    private TextView poidsPatient;
    private TextView taillePatient;
    private TextView groupeSanguinPatient;
    private TextView temperaturePatient;

    private TextView tensionPatient;
    private TextView bpmPatient;
    private TextView tpsSommeilPatient;
    private TextView caloriesDepenseesPatient;
    private TextView nbPasPatient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent myIntent = getIntent();
        String id = myIntent.getStringExtra("id");
        int nbMesure = 2;
        setContentView(R.layout.details_patients);

        numSecu = (TextView) findViewById(R.id.NumSecuPatientText);
        nomPatient = (TextView) findViewById(R.id.LastNamePatientText);
        prenomPatient = (TextView) findViewById(R.id.FirstNamePatientText);
        dateNaissance = (TextView) findViewById(R.id.DatePatientText);
        adressePatient = (TextView) findViewById(R.id.AdressePatientText);
        telPatient = (TextView) findViewById(R.id.TelPatientText);
        emailPatient = (TextView) findViewById(R.id.EmailPatientText);
        sexePatient = (TextView) findViewById(R.id.SexePatientText);
        poidsPatient = (TextView) findViewById(R.id.PoidsPatientText);
        taillePatient = (TextView) findViewById(R.id.TaillePatientText);
        groupeSanguinPatient = (TextView) findViewById(R.id.GroupeSanguinPatientText);
        temperaturePatient = (TextView) findViewById(R.id.temperaturePatientText);
        tensionPatient = (TextView) findViewById(R.id.tensionPatientText);
        bpmPatient = (TextView) findViewById(R.id.bpmPatientText);
        tpsSommeilPatient = (TextView) findViewById(R.id.tpsSommeilPatientText);
        caloriesDepenseesPatient = (TextView) findViewById(R.id.caloriesDepenseesPatientText);
        nbPasPatient = (TextView) findViewById(R.id.nbPasPatientText);


        (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=affPatientMesures&ID_PATIENT="+ id);

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

            try {
                    JSONObject j = new JSONObject(result);
                    numSecu.setText(j.getString("NUMSECU_PATIENT").toString());
                    nomPatient.setText(j.getString("NOM_PATIENT").toString());
                    prenomPatient.setText(j.getString("PRENOM_PATIENT").toString());
                    dateNaissance.setText(j.getString("DATE_NAISSANCE").toString());
                    adressePatient.setText(j.getString("ADRESSE_POSTALE_PATIENT").toString());
                    telPatient.setText(j.getString("TELEPHONE_PATIENT").toString());
                    emailPatient.setText(j.getString("MAIL_PATIENT").toString());
                    sexePatient.setText(j.getString("SEXE_PATIENT").equals("0")?"Femme":"Homme");
                    groupeSanguinPatient.setText(j.getString("GroupeSanguin_Patient").toString());

                    poidsPatient.setText(j.getString("POIDS").toString()+"Kg" );
                    taillePatient.setText(j.getString("TAILLE").toString()+"cm");

                    temperaturePatient.setText(j.getString("TEMPERATURE").toString());
                    tensionPatient.setText(j.getString("TENSION").toString());
                    bpmPatient.setText(j.getString("BPM").toString());
                    tpsSommeilPatient.setText(j.getString("TEMPSSOMMEIL").toString());
                    caloriesDepenseesPatient.setText(j.getString("CALORIESDEPENSEES").toString()+"Kcal");
                    nbPasPatient.setText(j.getString("NBPAS").toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }



            // Do things like hide the progress bar or change a TextView
        }
    }
}
