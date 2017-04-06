package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                UpdateAffichage(false);
            }
        });

        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateAffichage(false);
            }
        });
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
}
