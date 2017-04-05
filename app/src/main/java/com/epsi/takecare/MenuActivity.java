package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by gael on 05/04/2017.
 */

public class MenuActivity extends Activity {
    private Button btnProfil;
    private Button btnDeconnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        btnProfil = (Button) findViewById(R.id.btnProfil);
        btnDeconnexion = (Button) findViewById(R.id.btnDeconnexion);

        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profilIntent = new Intent(view.getContext(), MyAccount.class);
                startActivity(profilIntent);
            }
        });

        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDeconexion(view);
            }
        });
    }


    private void onClickDeconexion(View v){
        Intent DecoIntent = new Intent(v.getContext(), Connexion.class);
        startActivity(DecoIntent);
    }
}
