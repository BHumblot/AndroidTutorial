package org.esiea.humblot.benoit.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Secondary_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_);
        GetTanks.startActionDL(getApplicationContext());
    }
}
