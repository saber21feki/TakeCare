package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gael on 05/04/2017.
 */

public class ListePatient extends ActionBarActivity {
    ListView mListView;
    String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier", "Yann", "Zoé"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_patients);
        mListView = (ListView) findViewById(R.id.PatientList);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(view.getContext(), DetailPatient.class);
                startActivity(myIntent);
            }
        });
        //afficherListeNoms();
        afficherListePatients();
    }

    private void afficherListeNoms(){
        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListePatient.this, android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);
    }

    private List<Patient> genererPatients(){
        List<Patient> patients = new ArrayList<Patient>();
        patients.add(new Patient(1,"Roehrig", "Yann", "02/04/1990"));
        patients.add(new Patient("Benezech", "Eugénie", "13/05/1990"));
        patients.add(new Patient("Feki", "Saber", "21/05/1990"));
        return patients;
    }

    private void afficherListePatients() {
        List<Patient> patients = genererPatients();

        PatientAdapter adapter = new PatientAdapter(ListePatient.this, patients);
        mListView.setAdapter(adapter);
    }
}