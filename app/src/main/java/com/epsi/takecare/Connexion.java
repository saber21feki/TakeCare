package com.epsi.takecare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Connexion extends AppCompatActivity {

    private Button btnConnexion;
    private EditText etPwd;
    private EditText etId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        etId = (EditText) findViewById(R.id.Identifiant);
        etPwd = (EditText) findViewById(R.id.MotDePasse);
        btnConnexion = (Button) findViewById(R.id.buttonConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TODO : vérification d'authentification*/
                Intent myIntent = new Intent(v.getContext(), ListePatient.class);
                startActivity(myIntent);
            }
        });
    }
}
