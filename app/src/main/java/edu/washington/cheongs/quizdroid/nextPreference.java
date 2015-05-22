package edu.washington.cheongs.quizdroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class nextPreference extends ActionBarActivity {
    private PendingIntent pendingIntent;
    private EditText url;
    private EditText timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        final Intent alarmIntent = new Intent(nextPreference.this, Receiver.class);

        url = (EditText) findViewById(R.id.urlEdit);
        timer = (EditText) findViewById(R.id.timerEdit);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().equals("Start")) {
                    if (!url.getText().toString().trim().equals("") &&
                            !timer.getText().toString().trim().equals("")) {

                        button.setText("Stop");

                        alarmIntent.putExtra("url", url.getText().toString());
                        pendingIntent = PendingIntent.getBroadcast(nextPreference.this, 0, alarmIntent, 0);

                        start();
                    }
                } else {
                    button.setText("Start");
                    stop();
                }
            }
        });
    }

    public void stop() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        pendingIntent.cancel();

        Toast.makeText(this, "Alarm stopped", Toast.LENGTH_SHORT).show();
    }

    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = Integer.parseInt(timer.getText().toString()) * 1000 * 60;

        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}