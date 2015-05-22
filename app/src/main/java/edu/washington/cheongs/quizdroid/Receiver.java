package edu.washington.cheongs.quizdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String url = intent.getStringExtra("url");
        Toast.makeText(context, "Questions downloaded from: " + url, Toast.LENGTH_SHORT).show();
    }
}