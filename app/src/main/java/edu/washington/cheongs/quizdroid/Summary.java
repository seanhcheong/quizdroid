package edu.washington.cheongs.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Summary extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent launchedMe = getIntent();
        final String topic = launchedMe.getStringExtra("topic");
        String answer = launchedMe.getStringExtra("answer");
        final int count = launchedMe.getIntExtra("count", 0);
        int num = launchedMe.getIntExtra("num", 0);

        TextView summary = (TextView) findViewById(R.id.summary);
        TextView selected = (TextView) findViewById(R.id.chosenAnswer);
        TextView correctAnswer = (TextView) findViewById(R.id.correctAnswer);
        TextView numCorrect = (TextView) findViewById(R.id.numCorrect);

        summary.setText(topic);
        selected.setText("Your answer was: " + answer);

        if (topic.equals("Physics")) {
            if (count == 1) {
                correctAnswer.setText("Correct Answer: Apple");
            } else if (count == 2) {
                correctAnswer.setText("Correct Answer: 3 Times");
            } else if (count == 3) {
                correctAnswer.setText("Correct Answer: 9.8 m/s/s");
            }

            if (answer.equals("Apple") || answer.equals("3 Times") ||
                    answer.equals("9.8 m/s/s")) {
                num++;
            }
        } else if (topic.equals("Math")) {
            if (count == 1) {
                correctAnswer.setText("Correct Answer: 16");
            } else if (count == 2) {
                correctAnswer.setText("Correct Answer: 28");
            } else if (count == 3) {
                correctAnswer.setText("Correct Answer: 6");
            }

            if (answer.equals("16") || answer.equals("28") || answer.equals("6")) {
                num++;
            }
        } else if (topic.equals("Marvel Super Heroes")) {
            if (count == 1) {
                correctAnswer.setText("Correct Answer: Photographer");
            } else if (count == 2) {
                correctAnswer.setText("Correct Answer: Tony Stark");
            } else if (count == 3) {
                correctAnswer.setText("Correct Answer: Cosmic Storm");
            }

            if (answer.equals("Photographer") || answer.equals("Tony Stark") ||
                    answer.equals("Cosmic Storm")) {
                num++;
            }
        }

        numCorrect.setText("You have " + num + " out of 3 correct");
        final int number = num;

        Button next = (Button) findViewById(R.id.next);
        if (count == 3) {
            next.setText("Finish");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent restart = new Intent(Summary.this, TopicsList.class);
                    startActivity(restart);
                }
            });
        } else {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent next = new Intent(Summary.this, Testing.class);
                    next.putExtra("topic", topic);
                    next.putExtra("count", count);
                    next.putExtra("num", number);
                    startActivity(next);
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summary, menu);
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