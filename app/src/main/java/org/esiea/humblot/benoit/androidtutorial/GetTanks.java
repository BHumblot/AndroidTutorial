package org.esiea.humblot.benoit.androidtutorial;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetTanks extends IntentService
{

    private static final String ACTION_DL = "org.esiea.humblot.benoit.androidtutorial.action.FOO";


    public GetTanks()
    {
        super("GetTanks");
    }

    public static void startActionDL(Context context)
    {
        Intent intent = new Intent(context, GetTanks.class);
        intent.setAction(ACTION_DL);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null)
        {
            final String action = intent.getAction();
            if (ACTION_DL.equals(action))
            {
                handleActionFoo();
            }
        }
    }

    private void handleActionFoo()
    {
        Log.i("SERVICELOG","GetTanks Service launched and have sent a log.");
        Log.d("SERVICETHREAD","Thread service name : "+Thread.currentThread().getName());
        Log.i("CACHEDIR", getCacheDir().toString());

        URL url = null;

        try
        {
            url = new URL("http://api.worldoftanks.ru/2.0/encyclopedia/tanks/?application_id=171745d21f7f98fd8878771da1000a31");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if(HttpURLConnection.HTTP_OK == conn.getResponseCode())
            {
                copyInputStreamToFile(conn.getInputStream(), new File((getCacheDir()), "tanks.json"));
                Log.d("FILE","Json apparently downloaded");
            }
            else
            {
                Log.i("ACTUALRESPONSE", "Actual response code : "+conn.getResponseCode());
            }
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void copyInputStreamToFile(InputStream in, File file)
    {
        try
        {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0)
            {
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
