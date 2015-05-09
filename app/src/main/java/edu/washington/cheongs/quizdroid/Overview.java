package edu.washington.cheongs.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


public class Overview extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Intent launchedMe = getIntent();
        final String topic = launchedMe.getStringExtra("topic");
        TextView title = (TextView) findViewById(R.id.title);
        TextView desc = (TextView) findViewById(R.id.desc);
        TextView num = (TextView) findViewById(R.id.num);

        if (topic.equals("Physics")) {
            title.setText("Welcome to the Physics Quiz!");
            desc.setText("Test your knowledge on some physics trivia!");
            num.setText("Question Count: 3");
        } else if (topic.equals("Math")) {
            title.setText("Welcome to the Math Quiz!");
            desc.setText("Do you think you're smarter than a 5th grader? Test your mathematical skills");
            num.setText("Question Count: 3");
        } else if (topic.equals("Marvel Super Heroes")) {
            title.setText("Welcome to the Marvel Super Heroes Quiz");
            desc.setText("Marvel, Not DC super heroes! Test your knowledge!");
            num.setText("Question Count: 3");
        }

        Button begin = (Button) findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz = new Intent(Overview.this, Testing.class);
                quiz.putExtra("topic", topic);
                quiz.putExtra("count", 0);
                quiz.putExtra("num", 0);
                startActivity(quiz);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topics_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}