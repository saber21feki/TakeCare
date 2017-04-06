package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
        //Patient patient = ws.getPatientById(Integer.getInteger(id));
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


       /* numSecu.setText(patient.getNumsecu_patient());
        nomPatient.setText(patient.getNom_patient());
        prenomPatient.setText(patient.getPrenom_patient());
        dateNaissance.setText(patient.getDate_naissance());
        adressePatient.setText(patient.getAdresse_postale_patient());
        telPatient.setText(patient.getTelephone_patient());
        emailPatient.setText(patient.getMail_patient());
        sexePatient.setText(patient.getSexe_patient());
        poidsPatient.setText(String.valueOf(patient.getPoids_patient()));
        taillePatient.setText(String.valueOf(patient.getTaille_patient()));
        groupeSanguinPatient.setText(patient.getGroupeSanguin_patient());
        temperaturePatient.setText(String.valueOf(patient.getTemperature_patient()));
        tensionPatient.setText(String.valueOf(patient.getTension_patient()));
        bpmPatient.setText(String.valueOf(patient.getBpm_patient()));
        tpsSommeilPatient.setText(String.valueOf(patient.getTpsSommeil_patient()));
        caloriesDepenseesPatient.setText(String.valueOf(patient.getCaloriesDepensees_patient()));
        nbPasPatient.setText(String.valueOf(patient.getNbPas_patient()));*/

    }
}
