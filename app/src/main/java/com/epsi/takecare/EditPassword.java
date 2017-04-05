package com.epsi.takecare;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by gael on 04/04/2017.
 */

public class EditPassword extends Activity {
    private Button btnValider;
    private EditText etVerifNewPwd;
    private EditText etNewPwd;
    private EditText etOldPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_password);

        final String oldPwd = "bonjour";
        etOldPwd = (EditText) findViewById(R.id.LastPwdText);
        etNewPwd = (EditText) findViewById(R.id.NewPwdText);
        etVerifNewPwd = (EditText) findViewById(R.id.VerifNewPwdText);
        btnValider = (Button) findViewById(R.id.ValiderNewPassword);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (etOldPwd.getText().toString().equals(oldPwd)){
                    if (IsNotNullOrEmpty(etNewPwd.getText().toString()) && IsNotNullOrEmpty(etVerifNewPwd.getText().toString())){
                        if(etNewPwd.getText().toString().equals(etVerifNewPwd.getText().toString())){
                            Intent validIntent = new Intent(view.getContext(), MyAccount.class);
                            startActivity(validIntent);
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
