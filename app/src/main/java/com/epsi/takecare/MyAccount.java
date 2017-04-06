package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static com.epsi.takecare.R.id.btnEditPwd;

/**
 * Created by gael on 04/04/2017.
 */

public class MyAccount extends Activity {
    private EditText etNom;
    private EditText etTel;
    private EditText etPrenom;
    private EditText etMail;
    private Button btnEditAcount;
    private Button btnEditPassword;
    private Button btnValider;
    private Button btnAnnuler;


    private String jtab = "{\"ID_CM\":\"1\",\"0\":\"1\",\"NOM_CM\":\"Leroy\",\"1\":\"Leroy\",\"PRENOM_CM\":\"Jean\",\"2\":\"Jean\",\"LOCALISATION_CM\":\"Montpellier\",\"3\":\"Montpellier\",\"ADRESSE_CM\":\"Rue Victor Hugo\",\"4\":\"Rue Victor Hugo\",\"CP_CM\":\"34125\",\"5\":\"34125\",\"VILLE_CM\":\"Montpellier\",\"6\":\"Montpellier\",\"TELEPHONE_CM\":\"0423575923\",\"7\":\"0423575923\",\"POSTE_CM\":\"Infirmier\",\"8\":\"Infirmier\",\"NOM_HOPITAL_CM\":\"CHU Montpellier\",\"9\":\"CHU Montpellier\",\"MAIL_CM\":\"lj@email.com\",\"10\":\"lj@email.com\",\"MDP_CM\":\"abcd404235325\",\"11\":\"abcd404235325\"}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);

        //Corps_Medical infirmier = new Corps_Medical();

        //ws.getCorpsMedicalById(Integer.getInteger(id));

        etNom = (EditText) findViewById(R.id.etNomAccount);
        etPrenom = (EditText) findViewById(R.id.etPrenomAccount);
        etTel = (EditText) findViewById(R.id.etTelAcount);
        etMail = (EditText) findViewById(R.id.etMailAccount);
        btnEditAcount = (Button) findViewById(R.id.btnEditAccount);
        btnEditPassword = (Button) findViewById(R.id.btnEditPwd);
        btnValider = (Button) findViewById(R.id.btnValidEdit);
        btnAnnuler = (Button) findViewById(R.id.btnCancelEdit);

        UpdateAffichage(false);

        btnEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent EditPwdIntent = new Intent(view.getContext(), EditPassword.class);
                startActivity(EditPwdIntent);
            }
        });

        btnEditAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateAffichage(true);
            }
        });

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateAffichage(false);
            }
        });

        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateAffichage(false);
            }
        });

        (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=affCorpsMedical&ID_CM="+ Connexion.Constante.Id_CM);


    }


    private void UpdateAffichage(boolean edit){
        if (edit){
            etTel.setEnabled(true);
            etMail.setEnabled(true);
            btnValider.setVisibility(View.VISIBLE);
            btnAnnuler.setVisibility(View.VISIBLE);
            btnEditAcount.setVisibility(View.INVISIBLE);
            btnEditPassword.setVisibility(View.INVISIBLE);
        }else{
            etNom.setEnabled(false);
            etPrenom.setEnabled(false);
            etTel.setEnabled(false);
            etMail.setEnabled(false);
            btnValider.setVisibility(View.INVISIBLE);
            btnAnnuler.setVisibility(View.INVISIBLE);
            btnEditAcount.setVisibility(View.VISIBLE);
            btnEditPassword.setVisibility(View.VISIBLE);
        }
    }



    /*etTel.setText(.getTel_CM());
    etMail.setText(infirmier.getMail_CM());*/


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
                JSONObject j = new JSONObject(result);
                etNom.setText(j.get("NOM_CM").toString());
                etPrenom.setText(j.get("PRENOM_CM").toString());
                etTel.setText(j.get("TELEPHONE_CM").toString());
                etMail.setText(j.get("MAIL_CM").toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Do things like hide the progress bar or change a TextView
        }
    }
}
