package com.epsi.takecare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by gael on 04/04/2017.
 */

public class EditPassword extends Activity {
    private Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_password);

        btnValider = (Button) findViewById(R.id.ValiderNewPassword);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent validIntent = new Intent(view.getContext(), MyAccount.class);
                startActivity(validIntent);
            }
        });
    }
}
