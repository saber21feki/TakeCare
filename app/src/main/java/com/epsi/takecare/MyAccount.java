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

import static com.epsi.takecare.Connexion.Constante.CM;
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
                if(!CM.getMail_CM().toString().equals(etMail.getText().toString()) || !CM.getTel_CM().toString().equals(etTel.getText().toString())){
                    if(Connexion.isValidEmail(etMail.getText())){
                        if(etTel.getText().length() == 10){
                            CM.setMail_CM(etMail.getText().toString());
                            CM.setTel_CM(etTel.getText().toString());
                            updateCM();
                        }else{
                            Toast.makeText(getApplicationContext(), "Téléphone invalid", Toast.LENGTH_LONG).show();
                            etTel.setText(CM.getTel_CM());
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Email invalid", Toast.LENGTH_LONG).show();
                        etMail.setText(CM.getMail_CM());
                    }
                }
                UpdateAffichage(false);
            }
        });

        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateAffichage(false);
                etTel.setText(CM.getTel_CM());
                etMail.setText(CM.getMail_CM());

            }
        });

        (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=affCorpsMedical&ID_CM="+ CM.getId_CM());


    }



    private void updateCM(){
        (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=editMailTelCorpsMedical&ID_CM="+ CM.getId_CM()+"&TELEPHONE_CM="+CM.getTel_CM()+"&MAIL_CM="+CM.getMail_CM());

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
                CM.setMdp_CM(j.getString("MDP_CM"));
                CM.setNom_Cm(j.getString("NOM_CM"));
                CM.setPrenom_CM(j.getString("PRENOM_CM"));
                CM.setLocalisation_CM(j.getString("LOCALISATION_CM"));
                CM.setAdress_CM(j.getString("ADRESSE_CM"));
                CM.setCp_CM(j.getString("CP_CM"));
                CM.setVille_CM(j.getString("VILLE_CM"));
                CM.setPoste_CM(j.getString("POSTE_CM"));
                CM.setNomHopital_CM(j.getString("NOM_HOPITAL_CM"));
                CM.setMail_CM(j.getString("MAIL_CM"));
                CM.setTel_CM(j.getString("TELEPHONE_CM"));

                etNom.setText(CM.getNom_Cm());
                etPrenom.setText(CM.getPrenom_CM());
                etTel.setText(CM.getTel_CM());
                etMail.setText(CM.getMail_CM());


            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Do things like hide the progress bar or change a TextView
        }
    }
}
