package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gael on 05/04/2017.
 */

public class ListePatient extends AppCompatActivity {
    ListView mListView;
    String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier", "Yann", "Zoé"
    };

    List<Patient> patients;
    private Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_patients);
        mListView = (ListView) findViewById(R.id.PatientList);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(view.getContext(), DetailPatient.class);
                Patient pat = (Patient) mListView.getItemAtPosition(i);
                myIntent.putExtra("id", String.valueOf(pat.getId_patient()));
                startActivity(myIntent);

            }
        });


        btnMenu = (Button) findViewById(R.id.buttonMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(view.getContext(), MenuActivity.class);
                startActivity(menuIntent);
            }
        });

        Toast.makeText(getApplicationContext(), "Chargement...", Toast.LENGTH_LONG).show();
        (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=listPatients&ID_CM="+ Connexion.Constante.Id_CM);


    }


    private List<Patient> genererPatients(ArrayList<JSONObject> j){
        patients = new ArrayList<Patient>();
        for (JSONObject jsO : j)
            try {
                patients.add(new Patient(Integer.parseInt(jsO.get("ID_PATIENT").toString()),jsO.get("NOM_PATIENT").toString(), jsO.get("PRENOM_PATIENT").toString(), jsO.get("DATE_NAISSANCE").toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return patients;
    }

    private void afficherListePatients(ArrayList<JSONObject> j) {
        patients = genererPatients(j);
        for(int i = 0 ; i < patients.size(); i++){
            Patient patient = patients.get(i);
            System.out.println(patient.getId_patient());
        }
        PatientAdapter adapter = new PatientAdapter(ListePatient.this, patients);
        mListView.setAdapter(adapter);
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
            try {
                result = result.replace("}{", "};{");
                String[] listresult = result.split(";");
                ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();

                for (String s:listresult) {
                    jsonObjectArrayList.add(new JSONObject(s));
                }

                afficherListePatients(jsonObjectArrayList);
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Aucun patient n'a été trouvé", Toast.LENGTH_LONG).show();
            }

            // Do things like hide the progress bar or change a TextView
        }
    }




}