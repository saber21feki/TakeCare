package com.epsi.takecare;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gael on 04/04/2017.
 */

public class EditPassword extends Activity {
    private Button btnValider;
    private EditText etVerifNewPwd;
    private EditText etNewPwd;
    private EditText etOldPwd;
    Intent validIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_password);
        etOldPwd = (EditText) findViewById(R.id.LastPwdText);
        etNewPwd = (EditText) findViewById(R.id.NewPwdText);
        etVerifNewPwd = (EditText) findViewById(R.id.VerifNewPwdText);
        btnValider = (Button) findViewById(R.id.ValiderNewPassword);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (etOldPwd.getText().toString().equals(Connexion.Constante.OldPWD_CM)){
                    if (IsNotNullOrEmpty(etNewPwd.getText().toString()) && IsNotNullOrEmpty(etVerifNewPwd.getText().toString())){
                        if(etNewPwd.getText().toString().equals(etVerifNewPwd.getText().toString())){

                            Toast.makeText(getApplicationContext(), "Chargement...", Toast.LENGTH_LONG).show();
                            (new MyAsyncTask()).execute("http://perso.montpellier.epsi.fr/~gael.renault/takeCare/ws.php?action=editMDPCorpsMedical&ID_CM="+ Connexion.Constante.Id_CM+"&MDP_CM="+etNewPwd.getText());

                            validIntent = new Intent(view.getContext(), MyAccount.class);

                        }else{
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
                            alertDialogBuilder.setTitle("les nouveaux mot de passe saisi ne sont pas les même");
                            alertDialogBuilder
                                    .setCancelable(false)
                                    .setNegativeButton("Fermer", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }else{
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
                        alertDialogBuilder.setTitle("Veuillez saisir un nouveau mot de passe");
                        alertDialogBuilder
                                .setCancelable(false)
                                .setNegativeButton("Fermer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }else{
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
                    alertDialogBuilder.setTitle("L'ancien mot de passe saisi n'est pas le bon");
                    alertDialogBuilder
                            .setCancelable(false)
                            .setNegativeButton("Fermer", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

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
                Toast.makeText(getApplicationContext(), "connexion réussite", Toast.LENGTH_LONG).show();
                startActivity(validIntent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Mauvais login", Toast.LENGTH_LONG).show();

            }
        }
    }

    private boolean IsNotNullOrEmpty(String s){
        boolean res = false;

        if (s!=null){
            if (!s.isEmpty()) {
                res = true;
            }
        }
        return res;
    }
}
