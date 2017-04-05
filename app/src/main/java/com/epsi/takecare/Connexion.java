package com.epsi.takecare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.epsi.takecare.R.id.Identifiant;
import static com.epsi.takecare.R.id.MotDePasse;
import static com.epsi.takecare.R.id.buttonConnexion;
import static com.epsi.takecare.R.layout.connexion;

public class Connexion extends AppCompatActivity {

    private Button btnConnexion;
    private EditText etPwd;
    private EditText etId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(connexion);

        etId = (EditText) findViewById(Identifiant);
        etPwd = (EditText) findViewById(MotDePasse);
        btnConnexion = (Button) findViewById(buttonConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ListePatient.class);
                startActivity(myIntent);
            }
        });
    }
}
