package org.esiea.humblot.benoit.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //rendre le 8 février à 20h au plus tard : evenisjonos@gmail.com


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_download:
                Intent intent = new Intent(getApplicationContext(), Secondary_Activity.class);
                startActivity(intent);
                break;
            case R.id.action_something:
                //put something here
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void goToDownloadJSON(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Secondary_Activity.class);
        startActivity(intent);

    }
}
//todo
//en/fr translation
//graphic elements
//2 pattern (landscape and portrait)
//2 activities
//notifications : toast, notification, dialog box, etc...
//at least, one button in the action bar
//download service
//notification at the end of download
//downloaded data treatment
//call toward exterior API
//display of data :
//-listview with single textview (minimum)
//-listview with several textview (better)
//-recyclerview(ideal)
